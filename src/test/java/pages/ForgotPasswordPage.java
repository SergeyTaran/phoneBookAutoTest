package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static pages.LoginPage.*;
import static utils.Constants.*;

public class ForgotPasswordPage extends PageObject {



    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"password-recovery-form\"]/div[1]/div[1]/div/input")
    public static WebElement passwordNewField;
    @FindBy(xpath = "//*[@id=\"password-recovery-form\"]/div[2]/div[1]/div/input")
    public static WebElement passwordConfirmField;
    @FindBy(xpath = "//*[@id=\"password-recovery-form\"]/div[3]/div[1]/button")
    public static WebElement passwordSubmitBtn;
    @FindBy(id = "success-message")
    public static WebElement successMsg;
    @FindBy(id = "confirm-password-error-matcher")
    public static WebElement errorMsg;
    @FindBy(xpath = "//*[@id=\"forgot-pass-form\"]/div[2]/div[1]/button")
    public static WebElement sendBtn;




    public void retrievePassword_sendRequestOnEmail(String user){
        driver.get(forgotPassUrl);
        loginField.sendKeys(user);
        sendBtn.click();

    }

    public void retrievePassword_setNewPass(String password, String confirmPassword) throws InterruptedException {
        EmailPage emailPage = new EmailPage(driver);
        emailPage.getEnterNewPassUrl();
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
