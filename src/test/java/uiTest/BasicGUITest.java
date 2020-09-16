package uiTest;

import org.junit.Before;
import uiTest.pages.LoginPage;
import uiTest.pages.MainPage;
import uiTest.utils.FunctionalTest;

public class BasicGUITest extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;

    String user = "cepera_hawk@ukr.net";
    String password = "";
    String baseURL = "http://localhost:4200/";

    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);
    }
}
