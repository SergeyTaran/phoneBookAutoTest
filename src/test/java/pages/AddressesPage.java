package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import static pages.PhonesPage.*;

public class AddressesPage extends PageObject {

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ngb-nav-41")
    public static WebElement addressesLink;
    @FindBy(id = "btn-add-phone")
    public static WebElement addAddressBtn;


    public void addAddress(){
        contactExisted.click();
        addressesLink.click();
        addAddressBtn.click();
        countryCodeList.click();
        countryAustria.click();

    }
}
