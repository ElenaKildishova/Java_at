package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.Test;
import ru.p4b.dev.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Elena", "Kildishova", "+79139507792", "elenanov@ngs.ru", "[none]"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("E", "K", "+79130000000", "elenanova@ngs.ru", "[none]"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
