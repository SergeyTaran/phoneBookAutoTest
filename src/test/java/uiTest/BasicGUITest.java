package uiTest;

import org.junit.Before;
import org.junit.Test;
import uiTest.pages.LoginPage;
import uiTest.pages.MainPage;
import uiTest.pages.RegistrationConfirmationPage;
import uiTest.pages.RegistrationPage;
import uiTest.utils.FunctionalTest;

import static org.junit.Assert.assertEquals;

public class BasicGUITest extends FunctionalTest {

    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage;

    private String userName = "qatest.taran02@gmail.com";
    private String userRandomName = System.currentTimeMillis() + "@mail.com";
    private String password = "01234567890";
    private String baseURL = "http://localhost:4200/";
    private String signUpUrl = "http://localhost:4200/user/registration";

    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(userName, password);
    }

    @Test
    public void testCreateUser() {
        driver.get(signUpUrl);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm(userRandomName, password, password);

        assertEquals(false, registrationPage.isBtnSubmitDisabled());

        RegistrationConfirmationPage confirmationPage = registrationPage.clickSubmit();

        assertEquals("Please, check your email and activate your account.", confirmationPage.getConfirmationPageText());
        assertEquals("http://localhost:4200/user/activate-email", driver.getCurrentUrl());
    }

    @Test
    public void testPasswordLongerThen20() {
        driver.get(signUpUrl);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegisterForm(userRandomName, "01234", password + password);

        assertEquals(true, registrationPage.isBtnSubmitDisabled());
//        assertEquals("Password must be at least 8 characters.", registrationPage.passwordGetErrorText());
    }
}
