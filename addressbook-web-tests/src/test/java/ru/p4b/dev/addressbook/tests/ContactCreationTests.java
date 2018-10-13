package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.Test;
import ru.p4b.dev.addressbook.model.ContactData;
import ru.p4b.dev.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Helen").withLastName("Kildishova").withMobilePhone("+79139507792").withEmail("elenanov@ngs.ru").withGroup("[none]");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
