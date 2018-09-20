package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.gotoHomePage();
    app.selectContact();
    app.acceptNextAlert = true;
    app.deleteSelectedContacts();
    app.wd.switchTo().alert().accept();
    app.gotoHomePage();
    app.logout();
  }

}
