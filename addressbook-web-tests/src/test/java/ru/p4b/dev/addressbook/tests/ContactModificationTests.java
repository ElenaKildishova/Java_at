package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.p4b.dev.addressbook.model.ContactData;
import ru.p4b.dev.addressbook.model.Contacts;
import ru.p4b.dev.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstName("C").withLastName("D").withMobilePhone("+79139500000")
              .withEmail("SSS@ngs.ru").inGroup(groups.iterator().next()), true);
    }
  }

  @Test
  public void testContactModification() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/1.png");
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("W1").withLastName("z1").withHomePhone("77777")
            .withMobilePhone("+791300000").withWorkPhone("556-667").withEmail("111@ngs.ru").withEmail2("55@888")
            .withEmail3("DDD@LLL").withAddress("Novosibirsk").inGroup(groups.iterator().next()).withPhoto(photo);
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
