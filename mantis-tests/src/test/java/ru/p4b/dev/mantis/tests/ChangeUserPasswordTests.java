package ru.p4b.dev.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.p4b.dev.mantis.appmanager.HttpSession;
import ru.p4b.dev.mantis.model.MailMessage;
import ru.p4b.dev.mantis.model.UserData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangeUserPasswordTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testPasswordChanging() throws IOException {
    String newPassword = "NewPassword";
    app.goTo().LoginPage();
    app.user().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.goTo().ManageUserPage();
    UserData user = app.db().users().iterator().next();
    app.goTo().UserPage(user.getId());
    app.user().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
    app.registration().finish(confirmationLink, newPassword);
    HttpSession session = app.newSession();
    assertTrue(session.login(user.getName(), newPassword));
    assertTrue(session.isLoggedInAs(user.getName()));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
      MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
    }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
