package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static utils.Constants.*;

public class EmailPage extends PageObject {


    public EmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mailbox:login-input")
    public static WebElement loginFieldMail;
    @FindBy(xpath = "//*[@id=\"mailbox:submit-button\"]/input")
    public static WebElement nextBtn;
    @FindBy(id = "mailbox:password-input")
    public static WebElement passwordFieldMail;
    @FindBy(xpath = "//*[@id=\"mailbox:submit-button\"]/input")
    public static WebElement nextBtn2;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/a[1]/div[4]")
    public static WebElement confTokenLetter;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[1]/div[3]")
    public static WebElement tokenLinkMsg;



    public String getRegToken(String user, String password) throws InterruptedException {
        driver.get(urlMailRu);
        loginFieldMail.sendKeys(user);
        nextBtn.click();
        passwordFieldMail.sendKeys(password);
        nextBtn2.click();
//        driver.wait(50000);
        confTokenLetter.click();
        String regToken = tokenLinkMsg.getText().split("y/", 2)[1];
        System.out.println(regToken);
        return regToken;

    }

    public void getEnterNewPassUrl() throws InterruptedException {
        String tokenUrl = passRecoveryUrl + getRegToken(userMailRu, passMailRu);
        driver.get(tokenUrl);
    }


}
