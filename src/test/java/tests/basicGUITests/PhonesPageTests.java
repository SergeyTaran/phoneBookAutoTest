package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.PhonesPage;
import utils.FunctionalTest;
import static org.junit.Assert.assertEquals;
import static pages.ContactsPage.*;
import static pages.PhonesPage.*;
import static utils.Constants.*;


public class PhonesPageTests extends FunctionalTest {

    PhonesPage phonesPage = new PhonesPage(driver);


    @Before
    public void init() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted);

    }

    @Test
    public void test001_contacts_addPhone_editPhone_deletePhone(){
        phonesPage.addPhone(contactPhone);

        assertEquals(true, confStringPhoneSaved.isDisplayed());
        phonesPage.closeAddPhoneWin();

        assertEquals(contactPhone, phoneNumberField.getText());
        assertEquals(true, managePhoneBtn.isEnabled());

        phonesPage.editPhone(contactPhone);

        assertEquals(true, confStringPhoneSaved2.isDisplayed());
        assertEquals(true, logoutBtn.isEnabled());

        phonesPage.deletePhone();

        assertEquals(true, phonesPage.noResultsIsDisplayed());
        assertEquals(true, logoutBtn.isEnabled());

    }

//    @Test
//    public void test002_Contacts_EditPhone(){
//        phonesPage.editPhone(contactPhone);
//
//        assertEquals(true, confStringPhoneSaved2.isDisplayed());
//        assertEquals(true, logoutBtn.isEnabled());
//
//    }

//    @Test
//    public void test003_Contacts_DeletePhone(){
//        phonesPage.deletePhone();
//
//        assertEquals(true, phonesPage.noResultsIsDisplayed());
//        assertEquals(true, logoutBtn.isEnabled());
//
//    }

    @Test
    public void test004_Contacts_LinksAreActive(){
        phonesPage.getPhoneTab();

        assertEquals(true, countryCodeSorter.isEnabled());
        assertEquals(true, phoneNumberSorter.isEnabled());
    }

    @Test
    public void test005_Contacts_EditNotExistedPhone(){
        phonesPage.getPhoneTab();

        assertEquals(true, phonesPage.noResultsIsDisplayed());
        assertEquals(true, logoutBtn.isEnabled());
    }

    @Test
    public void test006_Contacts_PhoneIsTooShort(){
        phonesPage.addPhone("1234");

        assertEquals("Allowed length of the phone number must be between 5 and 12 digits", phonesPage.getErrTextPhoneLength());
        assertEquals(false, savePhoneBtn.isEnabled());
        assertEquals("Add new phone", phonesPage.getTextAddPhonePageTitle());

    }

    @Test
    public void test007_Contacts_PhoneIsTooLong(){
        phonesPage.addPhone(contactPhone + "00000000");

        assertEquals("Allowed length of the phone number must be between 5 and 12 digits", phonesPage.getErrTextPhoneLength());
        assertEquals(false, savePhoneBtn.isEnabled());
        assertEquals("Add new phone", phonesPage.getTextAddPhonePageTitle());

    }

    @Test
    public void test008_Contacts_PhoneIsWrongFormat(){
        phonesPage.addPhone("wrongformat");

        assertEquals("Allowed length of the phone number must be between 5 and 12 digits", phonesPage.getErrTextPhoneLength());
        assertEquals(false, savePhoneBtn.isEnabled());
        assertEquals("Add new phone", phonesPage.getTextAddPhonePageTitle());

    }



}
