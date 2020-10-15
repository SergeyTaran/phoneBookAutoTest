package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.ContactsPage;
import pages.LoginPage;
import pages.PasswordPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static pages.ContactsPage.*;
import static pages.PasswordPage.*;
import static utils.Constants.*;

public class PasswordPageTests extends FunctionalTest {


    LoginPage loginPage = new LoginPage(driver);
    PasswordPage passwordPage = new PasswordPage(driver);
    ContactsPage contactsPage = new ContactsPage(driver);

    @Before
    public void init() {
        driver.get(passwordPageUrl);
    }

    @Test
    public void test001_changePassword(){
        passwordPage.changePassword(passwordExisted, passwordExisted);

        assertEquals(passwordPageUrl, driver.getCurrentUrl());
        assertEquals("Your password has been successfully changed", passwordPage.getTextSuccessMsg());
    }

    @Test
    public void test002_changePasswordTooShort(){

        loginPage.login(userExisted, passwordExisted);
        accountBtn.click();
        passwordNewField.sendKeys(shortPass);

        assertEquals("Password must be at least 8 characters.", loginPage.getErrTextShortPass());
        assertEquals(false, passwordPage.checkSubmitBtn());
        assertEquals(passwordPageUrl, driver.getCurrentUrl());

    }

    @Test
    public void test003_changePasswordTooLong(){
        loginPage.login(userExisted, passwordExisted);
        accountBtn.click();
        passwordNewField.sendKeys(longPass);

        assertEquals("Password must be at least 20 characters.", loginPage.getErrTextLongPass());
        assertEquals(false, passwordPage.checkSubmitBtn());
        assertEquals(passwordPageUrl, driver.getCurrentUrl());
    }

    @Test
    public void test004_changePasswordNotMatch(){
        loginPage.login(userExisted, passwordExisted);
        accountBtn.click();
        passwordNewField.sendKeys(passwordExisted + "1");
        passwordConfirmField.sendKeys(passwordExisted);


        assertEquals("Passwords do not match.", errorMsg.getText());
        assertEquals(false, passwordPage.checkSubmitBtn());
        assertEquals(passwordPageUrl, driver.getCurrentUrl());
    }

}
