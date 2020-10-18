package tests.basicGUITests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ForgotPasswordPage;
import utils.FunctionalTest;

import static org.junit.Assert.assertEquals;
import static pages.ForgotPasswordPage.*;
import static utils.Constants.*;

public class ForgotPasswordPageTests extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);


    @Before
    public void init() {
        driver.get(passwordPageUrl);

    }

    @Test
    public void test001_changePassword_LengthValidation_PassNotMatch() throws InterruptedException {
        forgotPasswordPage.retrievePassword_sendRequestOnEmail(userMailRu);

        assertEquals("Password recovery instructions have been sent to " + userMailRu +".", forgotPasswordPage.getTextSuccessMsg());

        forgotPasswordPage.retrievePassword_setNewPass(passwordExisted, passwordExisted);

        assertEquals("Password changed successfully", forgotPasswordPage.getTextSuccessMsg());

        passwordNewField.clear();
        passwordNewField.sendKeys(shortPass);

        assertEquals("Password must be at least 8 characters.", loginPage.getErrTextShortPass());
        assertEquals(false, forgotPasswordPage.checkSubmitBtn());

        passwordNewField.clear();
        passwordNewField.sendKeys(longPass);

        assertEquals("Password must be no longer than 20 characters.", loginPage.getErrTextLongPass());
        assertEquals("Passwords confirmation does not match", errorMsg.getText());
        assertEquals(false, forgotPasswordPage.checkSubmitBtn());

    }


}
