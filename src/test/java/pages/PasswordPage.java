package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static pages.ContactsPage.accountBtn;
import static utils.Constants.*;

public class PasswordPage extends PageObject {



    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/div[1]/input")
    public static WebElement passwordNewField;
    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/div[2]/input")
    public static WebElement passwordConfirmField;
    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/button")
    public static WebElement passwordSubmitBtn;
    @FindBy(id = "success-message")
    public static WebElement successMsg;
    @FindBy(id = "password-confirm-error-matcher")
    public static WebElement errorMsg;


    public void changePassword(String password, String confirmPassword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userExisted, passwordExisted);
        ContactsPage contactsPage = new ContactsPage(driver);
        accountBtn.click();
        passwordNewField.sendKeys(password);
        passwordConfirmField.sendKeys(confirmPassword);
        passwordSubmitBtn.click();

    }

    public String getTextSuccessMsg(){
        return successMsg.getText();
    }

    public boolean checkSubmitBtn(){
        return passwordSubmitBtn.isEnabled();

    }




}
