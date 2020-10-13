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
    public void test000_Contacts_LinksAndButtonsAreActive() {

        assertEquals(true, contactsPage.linksAndBtnsAreActive());

    }

    @Test
    public void test001_Contacts_AddNewContact(){
        contactsPage.addNewContact(contactName, "Smith", contactAbout);

//        assertEquals("Contact saved successfully", ContactsPage.contactSavedMsg.getText());
        assertEquals(true, contactSavedMsg.isDisplayed());
        assertEquals(false, contactSaveBtn.isEnabled());

        ContactsPage.closeBtn.click();

        assertEquals(contactsUrl, getUrl());

    }



//    @Test
//    public void testGetAmountContacts(){
//        System.out.println(ContactsPage.getContactsListSize());
//        System.out.println(contactPhone);
//
//    }
}
