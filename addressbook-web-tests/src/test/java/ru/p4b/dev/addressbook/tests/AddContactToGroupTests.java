package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.p4b.dev.addressbook.model.ContactData;
import ru.p4b.dev.addressbook.model.GroupData;
import ru.p4b.dev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstName("A").withLastName("B").withMobilePhone("+7918000000")
              .withEmail("PPP@ngs.ru"), true);
    }
  }

  @Test
  public void testAddingContactToGroup() {
    Groups groups = app.db().groups();
    ContactData selectedContact = app.db().contacts().iterator().next();
    Groups beforeGroups = selectedContact.getGroups();
    if (beforeGroups.size() == groups.size()) {
      app.db().groups().add(new GroupData().withHeader("testN"));
    }
      app.goTo().homePage();
      app.contact().addToGroup(selectedContact);
    Groups afterGroups = selectedContact.getGroups();
    assertThat(afterGroups.size(), equalTo(beforeGroups.size() + 1));
  }
}
