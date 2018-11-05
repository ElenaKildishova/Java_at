package ru.p4b.dev.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.p4b.dev.mantis.appmanager.HttpSession;
import ru.p4b.dev.mantis.model.Users;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ChangeUserPasswordTests extends TestBase{

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testPasswordChanging() throws IOException {
    app.goTo().LoginPage();
    app.startSession().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.goTo().ManageUsersPage();
    Users users = app.db().users();

    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
