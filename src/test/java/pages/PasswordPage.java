package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static pages.ContactsPage.*;
import static pages.ForgotPasswordPage.*;

public class PasswordPage extends PageObject {

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/div[1]/input")
    public static WebElement newPassField;
    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/div[2]/input")
    public static WebElement confirmPassField;
    @FindBy(xpath = "//*[@id=\"pass-change-form\"]/button")
    public static WebElement submitPassBtn;
    @FindBy(id = "success-message")
    public static WebElement confMsg;
    @FindBy(id = "password-error-minlength")
    public static WebElement errMinLengthMsg;
    @FindBy(id = "password-error-maxlength")
    public static WebElement errMaxLengthMsg;
    @FindBy(id = "password-confirm-error-matcher")
    public static WebElement errPassNotMatchMsg;
    @FindBy(id = "password-error-required")
    public static WebElement errPassRequiredMsg;



    public void changePassword(String password, String confirmPass){
        changePasswordNewPass(password);
        changePasswordConfPass(confirmPass);
    }

    public void changePasswordNewPass(String password){
        accountBtn.click();
        newPassField.sendKeys(password);

    }

    public void changePasswordConfPass(String confirmPass){
        confirmPassField.sendKeys(confirmPass);
        submitPassBtn.click();
    }

    public String getTextConfMsg(){
        return confMsg.getText();

    }
}
