package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static pages.EmailPage.tokenLinkMsg;
import static utils.Constants.contactPhone;

public class ContactsPage extends PageObject {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div/button[1]")
    public static WebElement accountBtn;
    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/div/button[2]")
    public static WebElement logoutBtn;
    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[1]/a")
    public static WebElement contactsLink;
    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[2]/a")
    public static WebElement addNewContactLink;
    @FindBy(xpath = "/html/body/app-root/app-home-page/app-header/nav/div/ul/li[3]/a")
    public static WebElement searchContactLink;
    @FindBy(xpath = "/html/body/app-root/app-home-page/div/app-contacts/div[3]")
    public static WebElement contactsList;
    @FindBy(id = "form-name")
    public static WebElement contactNameField;
    @FindBy(id = "form-lastName")
    public static WebElement contactLastnameField;
    @FindBy(id = "form-about")
    public static WebElement contactAboutField;
    @FindBy(xpath = "//*[@id=\"add-contact-form\"]/div[4]/button[2]")
    public static WebElement contactSaveBtn;
    @FindBy(id = "saved-message")
    public static WebElement contactSavedMsg;
    @FindBy(xpath = "//*[@id=\"add-contact-modal\"]/a/span")
    public static WebElement closeBtn;
    @FindBy(xpath = "//*[@id=\"contacts-list\"]/div[1]/app-contact-item/div/button[2]/img")
    public static WebElement deleteRandomContactBtn;
    @FindBy(id = "check-box-remove-contact")
    public static WebElement confCheckBox;
    @FindBy(id = "submit-remove")
    public static WebElement submitRemoveContactBtn;
    @FindBy(id = "input-search-contact")
    public static WebElement contactSearchField;





    /**
     * get amount of contacts in List
      * @return number of contacts
     */
    public static int getContactsListSize(){
        return contactsList.findElements(By.tagName("div")).size()/2 - 1;
    }

    public boolean linksAndBtnsAreActive(){
        contactsLink.isEnabled();
        addNewContactLink.isEnabled();
        searchContactLink.isEnabled();
        accountBtn.isEnabled();
        logoutBtn.isEnabled();
        return true;
    }

    public void addNewContact(String name, String lastname, String about){
        addNewContactLink.click();
        contactNameField.sendKeys(name);
        contactLastnameField.sendKeys(lastname);
        contactAboutField.sendKeys(about);
        contactSaveBtn.click();

    }

    public void deleteRandomContact(){
        deleteRandomContactBtn.click();
        confCheckBox.click();
        submitRemoveContactBtn.click();
    }



}