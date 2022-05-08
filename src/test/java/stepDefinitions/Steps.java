package stepDefinitions;

import com.fasterxml.jackson.databind.ser.Serializers;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        configProp = new Properties();
        FileInputStream configPropFile = new FileInputStream("src/resources/config.properties");
        configProp.load(configPropFile);
        logger = Logger.getLogger("NewProject"); // Added logger
        PropertyConfigurator.configure("src/resources/log4j.properties");
        if (configProp.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {
        logger.info("***Launching browser******");
        loginPage = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        logger.info("***Opening URL******");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String username, String password) {
        logger.info("****Providing logging details******");
        loginPage.setUserName(username);
        loginPage.setPassword(password);
    }

    @When("Click on login")
    public void click_on_login() {
        loginPage.clickLogin();
    }

    @When("User click on log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
      loginPage.clickLogout();
      Thread.sleep(3000);
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            logger.info("****Login passed******");
            Assert.assertTrue(false);}
            else{
                logger.info("*****login failed****");
                Assert.assertEquals(title,driver.getTitle());
        }
    }

    @Then("close browser")
    public void close_browser() {
     driver.quit();
    }

    //Customer feature stepdefinitions

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        addcust = new AddcustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() {
        addcust.clickOnCustomerMenuOption();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() {
        addcust.clickOnCustomerMenuItem();
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() {
       addcust.clickOnAddNew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        logger.info("*******Adding new customer*********");
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        logger.info("*****Adding new customer*****");
        logger.info("****Entering customer information******");
      String email = randomString()+"@gmail.com";
      addcust.setEmail(email);
      addcust.setPassword("test123");
      addcust.setGender("Male");
      addcust.setFirstName("Pavan");
      addcust.setLastName("kumar");
      addcust.setDateOfBirth("07/04/1985");
      addcust.setCompanyName("busyQA");
      addcust.setAdminComment("This is for testing");
      addcust.setCustomerRoles("Guests");
      addcust.setOptionVendors("Vendor 2");
    }

    @When("click on Save button")
    public void click_on_Save_button() {
        logger.info("*****Saving customer data********");
        addcust.clickSaveButton();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String text) {
        logger.info("Verifying customer message displayed");
       Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(text));
    }

    //Steps for searching a customer using Email id
    @When("Enter customer Email")
    public void enter_customer_Email() {
     searchCustomerPage = new SearchCustomerPage(driver);
     searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
      searchCustomerPage.clickSearchButton();
      Thread.sleep(3000);
    }

    @Then("User should find Email in the search table")
    public void user_should_find_Email_in_the_search_table() {
        logger.info("*****Verifying the email in the search table******");
        boolean status = searchCustomerPage.searchCustomerByEmailID("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);
    }

    @When("Enter customer FirstName")
    public void enter_customer_FirstName() {
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setSearchFirstName("Victoria");
    }

    @When("Enter customer LastName")
    public void enter_customer_LastName() {
        searchCustomerPage.setSearchLirstName("Terces");
    }

    @Then("User should find Name in the search table")
    public void user_should_find_Name_in_the_search_table() {
        logger.info("*****Verifying the name in the search table******");
        boolean status = searchCustomerPage.searchCustomerByFirstNameAndLastName("Victoria","Terces");
        Assert.assertEquals(true,status);
    }

}
