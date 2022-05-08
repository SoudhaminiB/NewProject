package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement textEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement textPassword;

    @FindBy(xpath = "//button[@type='submit']" )
    @CacheLookup
    WebElement loginBtn;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserName(String uname){
        textEmail.clear();
        textEmail.sendKeys(uname);
    }

    public void setPassword(String pswd){
        textPassword.clear();
        textPassword.sendKeys(pswd);
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }


}
