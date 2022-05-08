package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;
    WaitHelper waithelper;

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);
    }

    @FindBy(css = "input#SearchEmail")
    WebElement searchEmail;

    @FindBy(css = "input#SearchFirstName")
    WebElement searchFirstName;

    @FindBy(css = "input#SearchLastName")
    WebElement searchLastName;

    @FindBy(css = "select#SearchMonthOfBirth")
    WebElement dobMonth;

    @FindBy(css = "select#SearchDayOfBirth")
    WebElement dobDay;

    @FindBy(css = "input#SearchCompany")
    WebElement searchCompany;

    @FindBy(css = "input#SearchIpAddress")
    WebElement searchIpAddress;

    @FindBy(css = "k-input")
    WebElement customerRoleInput;

    @FindBy(css = "button#search-customers")
    WebElement searchBtn;

    @FindBy(css = "table#customers-grid")
    WebElement table;

    @FindBy(css = ".dataTables_wrapper .dataTables_scrollBody table tr")
    List<WebElement> tableRows;

    @FindBy(css = ".dataTables_wrapper .dataTables_scrollBody table th")
    List<WebElement> tableColumns;

    @FindBy(css = ".dataTables_wrapper .dataTables_scrollBody table tr td")
    List<WebElement> tableCells;

    public void setEmail(String email) {
        waithelper.waitForElement(searchEmail, 30);
        searchEmail.clear();
        searchEmail.sendKeys(email);
    }

    public void setSearchFirstName(String firstname) {
        waithelper.waitForElement(searchFirstName, 30);
        searchFirstName.clear();
        searchFirstName.sendKeys(firstname);
    }

    public void setSearchLirstName(String lastname) {
        waithelper.waitForElement(searchLastName, 30);
        searchLastName.clear();
        searchLastName.sendKeys(lastname);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public int getNumberOfRows() {
        return tableRows.size();
    }

    public int getNumberOfColumns() {
        return tableColumns.size();
    }

    public boolean searchCustomerByEmailID(String email) {

        boolean flag = false;
        for (int i = 0; i < getNumberOfRows(); i++) {

            String emailid = table.findElement(By.xpath("//div[@id='customers-grid_wrapper'] //div[@class='dataTables_scroll'] //tr //td[2]")).getText();
            System.out.println(emailid);

            if (emailid.equals(email)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean searchCustomerByFirstNameAndLastName(String FirstName, String LastName) {
        boolean flag = false;
        for (int i = 0; i < getNumberOfRows(); i++) {

            String Name = table.findElement(By.xpath("//div[@id='customers-grid_wrapper'] //div[@class='dataTables_scroll'] //tr //td[3]")).getText();
            System.out.println(Name);
            String[] firstAndLast = Name.split(" ");
            if (firstAndLast[0].equals(FirstName) && firstAndLast[1].equals(LastName)) {
                flag = true;
            }

        }
        return flag;
    }

}
