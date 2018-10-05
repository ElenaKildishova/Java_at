package ru.p4b.dev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.p4b.dev.addressbook.model.ContactData;
import ru.p4b.dev.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Elena", "Kildishova", "+79139507792", "elenanov@ngs.ru", "[none]"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.logout();
  }
}
