package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class PhonesPage extends PageObject {


    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cc-select")
    public static WebElement countryCodeList;
    @FindBy(xpath = "//*[@id=\"cc-select\"]/option[16]")
    public static WebElement countryAustria;
    @FindBy(xpath = "//*[@id=\"cc-select\"]/option[229]")
    public static WebElement countryUkraine;
    @FindBy(id = "selected-cc")
    public static WebElement contactPhoneField;
    @FindBy(xpath = "//*[@id=\"phone-form\"]/div[1]/div[2]/div[2]/button")
    public static WebElement savePhoneBtn;
    @FindBy(xpath = "//*[@id=\"add-contact-modal\"]/a/span")
    public static WebElement closeAddPhoneBtn;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/tbody/tr/td[2]/ngb-highlight")
    public static WebElement phoneNumberField;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/tbody/tr[1]/td[3]/button")
    public static WebElement editPhoneBtn;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/tbody/tr/td[3]/div/button[2]")
    public static WebElement removeBtn;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/tbody/tr/td[3]/div/button[1]")
    public static WebElement edit;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/thead/tr/th[1]/a")
    public static WebElement countryCodeSorter;
    @FindBy(xpath = "//*[@id=\"items-table-phone\"]/thead/tr/th[2]/a")
    public static WebElement phoneNumberSorter;
    @FindBy(xpath = "//*[@id=\"phone-form\"]/div[2]/p/ngb-alert")
    public static WebElement phoneLengthErrMsg;
    @FindBy(xpath = "//*[@id=\"add-contact-modal\"]/h4")
    public static WebElement addNewPhoneWinTitle;
    @FindBy(xpath = "//*[@id=\"phone-form\"]/div[2]/p/ngb-alert")
    public static WebElement confStringPhoneSaved;
    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-phone-edit-modal/div[2]/p/ngb-alert")
    public static WebElement confStringPhoneSaved2;
    @FindBy(xpath = "//*[@id=\"contacts-list\"]/app-contact-item/button")
    public static WebElement contactExisted;
    @FindBy(id = "ngb-nav-3")
    public static WebElement contactLinkPhone;
    @FindBy(id = "ngb-nav-action")
    public static WebElement actionBtn;
    @FindBy(id = "btn-add-phone")
    public static WebElement addPhoneBtn;




    public void addPhone(String phone){
        contactExisted.click();
        contactLinkPhone.click();
        actionBtn.click();
        addPhoneBtn.click();
        countryCodeList.click();
        countryAustria.click();
        contactPhoneField.sendKeys(phone);
        savePhoneBtn.click();
    }

    public void closeAddPhoneWin(){
        closeAddPhoneBtn.click();

    }

    public void deletePhone(){
        contactExisted.click();
        contactLinkPhone.click();
        editPhoneBtn.click();
        removeBtn.click();

    }

    public String getTextNoResults(){
        return driver.findElement(By.xpath("//*[@id=\"ngb-nav-3-panel\"]/app-phone/div[2]/ngb-alert/b")).getText();
    }

    public void editPhone(String newPhone){
        contactExisted.click();
        contactLinkPhone.click();
        editPhoneBtn.click();
        edit.click();
        countryCodeList.click();
        countryUkraine.click();
        contactPhoneField.clear();
        contactPhoneField.sendKeys(newPhone);
        savePhoneBtn.click();

    }

    public void getPhoneTab(){
        contactExisted.click();
        contactLinkPhone.click();
    }

    public String getErrTextPhoneLength(){
        return phoneLengthErrMsg.getText();
    }

    public String getTextAddPhonePageTitle(){
        return addNewPhoneWinTitle.getText();
    }


}
