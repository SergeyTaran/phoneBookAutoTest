package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class LoginPage extends PageObject {

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div/button[2]")
    public static WebElement logoutBtn;
    @FindBy(id = "defaultRegisterFormEmail")
    public static WebElement loginField;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/div[1]/div/input")
    public static WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[3]/div[1]/button")
    public static WebElement loginBtn;
    @FindBy(id = "password-error-minlength")
    public static WebElement passShortErrMsg;
    @FindBy(id = "password-error-maxlength")
    public static WebElement passLongErrMsg;
    @FindBy(id = "email-error-required")
    public static WebElement emailIsEmptyErrMsg;
    @FindBy(id = "error-message")
    public static WebElement notExistsErrMsg;
    @FindBy(id = "password-error-required")
    public static WebElement passIsEmptyErrMsg;
    @FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/div/div/a[1]")
    public static WebElement regNewAccLink;
    @FindBy(xpath = "/html/body/app-root/app-login/div/div[1]/div/div/a[2]")
    public static WebElement forgotPassLink;
    @FindBy (id = "email-error-invalid")
    public static WebElement emailInvalidErrMsg;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTextLogout(){
        return logoutBtn.getText();
    }

    public boolean loginBtnIsEnabled(){
        return loginBtn.isEnabled();
    }

    public String getErrTextShortPass() {
        return passShortErrMsg.getText();
    }

    public String getErrTextLongPass() {
        return passLongErrMsg.getText();
    }

    public String getErrTextEmailIsEmpty() {
        return emailIsEmptyErrMsg.getText();
    }

    public String getErrTextPassIsEmpty() {
        return passIsEmptyErrMsg.getText();
    }

    public String getErrTextNotExist() {
        return notExistsErrMsg.getText();
    }

    public void regNewAccLinkClick(){
        regNewAccLink.click();
    }

    public void forgotPassLinkClick(){
        forgotPassLink.click();
    }

    public String getErrTextEmailInvalid(){
        return emailInvalidErrMsg.getText();
    }


    public ContactsPage login(String user, String password) {
        loginField.sendKeys(user);
        passwordField.sendKeys(password);
        loginBtn.click();
        return new ContactsPage(driver);
    }

    public LoginPage logout(){
        logoutBtn.click();
        return new LoginPage(driver);
    }

}