package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.ContactsPage;
import pages.LoginPage;
import pages.PasswordPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;


public class PasswordPageTests extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
//    ContactsPage contactsPage = new ContactsPage(driver);
    PasswordPage passwordPage = new PasswordPage(driver);


    @Before
    public void init() {
        driver.get(loginUrl);
        loginPage.login(userExisted, passwordExisted);

    }

    @Test
    public void test001_password_changePassword(){
        passwordPage.changePassword(passwordExisted, passwordExisted);

        assertEquals("Your password has been successfully changed", passwordPage.getTextConfMsg());
        assertEquals(passwordPageUrl, getUrl());
    }

    @Test
    public void test002_password_changePassword_PassTooShort(){
        passwordPage.changePasswordNewPass(shortPass);

        assertEquals("Password must be at least 8 characters.", PasswordPage.errMinLengthMsg.getText());
        assertEquals(passwordPageUrl, getUrl());
    }

    @Test
    public void test003_password_changePassword_PassTooLong(){
        passwordPage.changePasswordNewPass(longPass);

        assertEquals("Password must be at least 20 characters.", PasswordPage.errMaxLengthMsg.getText());
        assertEquals(passwordPageUrl, getUrl());
    }

    @Test
    public void test004_password_changePassword_PassNotMatch(){
        passwordPage.changePassword(passwordExisted, longPass);

        assertEquals("Passwords do not match.", PasswordPage.errPassNotMatchMsg.getText());
        assertEquals(passwordPageUrl, getUrl());
    }

    @Test
    public void test005_password_changePassword_EmptyField(){
        passwordPage.changePasswordNewPass("");
        driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/app-user-details-pgae/div/div[2]/div/app-account-password/div[1]")).click();

        assertEquals("Password is required.", PasswordPage.errPassRequiredMsg.getText());
        assertEquals(passwordPageUrl, getUrl());
    }
}
