package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import pages.ContactsPage;
import pages.LoginPage;
import utils.FunctionalTest;
import static pages.ContactsPage.*;
import static utils.Constants.*;

public class ContactsPageTests extends FunctionalTest {

    ContactsPage contactsPage = new ContactsPage(driver);

    @Before
    public void init() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted);

    }

    @Test
    public void test000_contacts_LinksAndButtonsAreActive() {

        assertEquals(true, contactsPage.linksAndBtnsAreActive());

    }

    @Test
    public void test001_contacts_AddNewContact(){
        System.out.println("Amount of contacts is: " + ContactsPage.getContactsListSize());
        contactsPage.addNewContact(contactName, "Smith", contactAbout);

//        assertEquals("Contact saved successfully", ContactsPage.contactSavedMsg.getText());
        assertEquals(true, contactSavedMsg.isDisplayed());
        assertEquals(false, contactSaveBtn.isEnabled());
        ContactsPage.closeBtn.click();

        System.out.println("Amount of contacts now is: " + ContactsPage.getContactsListSize());
        assertEquals(contactsUrl, getUrl());

    }

    @Test
    public void test002_contacts_deleteRandomContact(){
        contactsPage.deleteRandomContact();

        System.out.println("Amount of contacts now is: " + ContactsPage.getContactsListSize());
    }

    @Test
    public void test003_contacts_deleteSpecificContactWithSearch(){
        contactsPage.addNewContact("Heming", "Ernestuay", contactAbout);

        assertEquals(true, contactSavedMsg.isDisplayed());
        closeBtn.click();
        ContactsPage contactsPage = new ContactsPage(driver);
        System.out.println("Amount of contacts now is: " + ContactsPage.getContactsListSize());
        contactSearchField.sendKeys("Heming");
        contactsPage.deleteRandomContact();
        contactSearchField.clear();


        System.out.println("Amount of contacts now is: " + ContactsPage.getContactsListSize());
    }



    @Test
    public void test004_contacts_GetAmountContacts(){
        System.out.println(ContactsPage.getContactsListSize());

    }
}
