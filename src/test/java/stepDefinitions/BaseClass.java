package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;
import java.util.logging.Logger;

public class BaseClass {

    public WebDriver driver;
    public LoginPage loginPage;
    public AddcustomerPage addcust;
    public SearchCustomerPage searchCustomerPage;
    public static Logger logger;
    public Properties configProp;

    //Created for generating random strings for unique emailid
    public static String randomString(){
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return generatedString1;
    }
}
