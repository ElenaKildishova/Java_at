package ru.p4b.dev.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Elena", "Kildishova", "+79139507792", "elenanov@ngs.ru"));
    submitContactCreation();
    returnToHomePage();
    logout();
  }
}
