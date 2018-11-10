package ru.p4b.dev.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void LoginPage() {
    wd.get(app.getProperty("web.baseUrl") + "/login.php");
     }
  public void ManageUserPage() {
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));
  }

  public void UserPage(int id) {
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id)));
  }
}
