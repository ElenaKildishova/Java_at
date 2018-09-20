package ru.p4b.dev.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    gotoHomePage();
    selectContact();
    acceptNextAlert = true;
    deleteSelectedContacts();
    wd.switchTo().alert().accept();
    gotoHomePage();
    logout();
  }

}
