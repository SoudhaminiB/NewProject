package pageObjects;

import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddcustomerPage {

    public WebDriver ldriver;

    public AddcustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(css = ".brand-image-xl")
    WebElement logo;

    @FindBy(xpath = "//div[@class='os-content']/nav/ul/li //a[@href='#'] //p[contains(text(),'Customers')]")
    WebElement customerMenuOption;

    @FindBy(xpath = "//div[@class='os-content']/nav/ul/li //a[contains(@href,'/Admin/Customer/List')]")
    WebElement customerMenuItem;

    @FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
    WebElement addNew;

    @FindBy(xpath ="//input[@name='Email']")
    WebElement email;

    @FindBy(xpath ="//input[@name='Password']")
    WebElement password;

    @FindBy(xpath ="//input[@name='FirstName']")
    WebElement firstName;

    @FindBy(xpath ="//input[@name='LastName']")
    WebElement lastName;

    @FindBy(css ="#Gender_Female")
    WebElement genderFemale;

    @FindBy(css ="#Gender_Male")
    WebElement genderMale;

    @FindBy(css=".form-group .input-group-append .input-group")
    List<WebElement> customerRoles;

    @FindBy(xpath="//span[@title='delete']")
    WebElement deleteOption;

    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']")
    WebElement options;

//    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']/option[text()='Administrators']")
//    WebElement optionAdministrators;
//
//    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']/option[text()='Forum Moderators']")
//    WebElement optionForumModerators;
//
//    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']/option[text()='Guests']")
//    WebElement optionGuests;
//
//    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']/option[text()='Registered']")
//    WebElement optionRegistered;
//
//    @FindBy(xpath ="//select[@id='SelectedCustomerRoleIds']/option[text()='Vendors']")
//    WebElement optionVendors;

    @FindBy(id="VendorId")
    WebElement vendorOption;

    @FindBy(css ="input#DateOfBirth")
    WebElement dateOfBirth;

    @FindBy(css ="input#Company")
    WebElement companyName;

    @FindBy(css ="#AdminComment")
    WebElement adminComment;

    @FindBy(css = "button[name='save']")
    WebElement btnSave;

    public String getPageTitle(){
        return ldriver.getTitle();
    }

    public void clickOnCustomerMenuOption(){
        customerMenuOption.click();
    }

    public void clickOnCustomerMenuItem(){
        customerMenuItem.click();
    }

    public void clickOnAddNew(){
        addNew.click();
    }

    public void setEmail(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void setPassword(String pswd) {
        password.sendKeys(pswd);
    }

    public void setFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void setGender(String gender) {
     if(gender.equalsIgnoreCase("male"))
         genderMale.click();
     else
         genderFemale.click();
    }

    public void setCustomerRoles(String role){
        Actions act = new Actions(ldriver);
        deleteOption.click();
        act.sendKeys(customerRoles.get(1),role+Keys.ENTER).sendKeys(Keys.ENTER).build().perform();
        act.sendKeys(customerRoles.get(1),Keys.ENTER).build().perform();

    }


    public void setOptionVendors(String optionVendors) {
        Select select = new Select(vendorOption);
        select.selectByVisibleText(optionVendors);
    }


    public void setDateOfBirth(String dateofbirth) {
        dateOfBirth.sendKeys(dateofbirth);
    }

    public void setCompanyName(String companyname) {
        companyName.sendKeys(companyname);
    }

    public void setAdminComment(String admincomment) {
        adminComment.sendKeys(admincomment);
    }

    public void clickSaveButton(){
        btnSave.click();
    }
}
