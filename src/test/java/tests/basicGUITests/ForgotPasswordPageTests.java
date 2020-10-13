package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.EmailPage;
import pages.ForgotPasswordPage;
import utils.FunctionalTest;
import static org.junit.Assert.assertEquals;
import static utils.Constants.*;


public class ForgotPasswordPageTests extends FunctionalTest {

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    //  5

    @Before
    public void init(){
        driver.get(forgotPassUrl);
    }

    @Test
    public void testForgotLinkLoginEnable(){
        forgotPasswordPage.loginLinkClick();
        assertEquals(loginUrl, getUrl());
    }

    @Test
    public void testForgotLinkRegEnable(){
        forgotPasswordPage.regNewAccLinkClick();
        assertEquals(registrationUrl, getUrl());
    }

    @Test
    public void testRetrievePassGetToken(){
        forgotPasswordPage.resetPass(userMailRu);

        assertEquals("Password recovery instructions have been sent to " + userMailRu + ".", forgotPasswordPage.getTextConfStringPassChanged());
        assertEquals(forgotPassUrl, getUrl());

    }

    @Test //  ------------------------------------------------------------
    public void  testRetrievePassSetNewPass(){
        EmailPage emailPage = new EmailPage(driver);
        emailPage.getEnterNewPassUrl();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.setNewPass(passwordExisted, passwordExisted);

        assertEquals("Password changed successfully", forgotPasswordPage.getTextConfStringPassChanged());

    }

    @Test
    public void testRetrievePassWrongUser(){
        forgotPasswordPage.resetPass(wrongUser);

        assertEquals("Email must be a valid email address.", forgotPasswordPage.getTextErrWrongEmail());
        assertEquals(forgotPassUrl, getUrl());

    }
}
