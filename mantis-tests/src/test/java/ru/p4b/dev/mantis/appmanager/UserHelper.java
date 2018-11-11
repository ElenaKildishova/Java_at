package ru.p4b.dev.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("username"),username);
    type(By.name("password"),password);
    click(By.xpath("//input[@value='Login']"));
   }

   public void resetPassword() {
     click(By.xpath("//input[@value='Reset Password']"));
   }

}
