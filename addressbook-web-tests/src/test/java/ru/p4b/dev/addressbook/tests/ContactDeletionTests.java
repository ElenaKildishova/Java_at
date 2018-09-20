package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.acceptNextAlert = true;
    app.getContactHelper().deleteSelectedContacts();
    app.wd.switchTo().alert().accept();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }

}
