package ru.p4b.dev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.p4b.dev.addressbook.model.ContactData;
import ru.p4b.dev.addressbook.model.Contacts;
import ru.p4b.dev.addressbook.model.GroupData;
import ru.p4b.dev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroup extends TestBase{

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
  public void testContactFromGroupDeletion() {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData selectedContact = before.iterator().next();
    GroupData selectedGroup = app.db().groups().iterator().next();
    if (selectedContact.getGroups().size() == 0) {
      app.contact().addToGroup(selectedContact, selectedGroup);
    }
    Groups beforeGroups = selectedContact.getGroups();
    app.contact().removeFromGroup(selectedContact, selectedGroup);
    app.db().refresh(selectedContact);
    Groups afterGroups = selectedContact.getGroups();
    assertThat(afterGroups, equalTo(beforeGroups.without(selectedGroup)));
  }
}
