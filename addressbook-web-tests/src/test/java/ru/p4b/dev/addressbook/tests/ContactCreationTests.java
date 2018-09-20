package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.*;
import ru.p4b.dev.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Elena", "Kildishova", "+79139507792", "elenanov@ngs.ru"));
    app.submitContactCreation();
    app.returnToHomePage();
    app.logout();
  }
}
