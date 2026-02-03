package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class ValidCustomersPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerElement;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement deletecustomerElement;

    public ValidCustomersPage(WebDriver driver) {
        super(driver);
    }

    public void searchCustomer(String firstNameValue){
        searchCustomerElement.click();
        searchCustomerElement.sendKeys(firstNameValue);
    }
    public void validateCustomer(String firstNameValue, String lastNameValue, String postCodeValue){
        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(firstNameValue));
        Assert.assertTrue(customerTableRow.contains(lastNameValue));
        Assert.assertTrue(customerTableRow.contains(postCodeValue));
//        Assert.assertTrue(customerTableRow.contains(accountNumber));
    }
    public void deleteCustomer(){
        deletecustomerElement.click();
    }
}
