package pages;

import models.CustomerModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.LogUtility;

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

    public void searchCustomer(String firstNameValue) {
        searchCustomerElement.click();
        LogUtility.infoLog("The user clicks on Search Customer ");
        searchCustomerElement.sendKeys(firstNameValue);
        LogUtility.infoLog("The user fills Search field with value: " + firstNameValue);
    }

    public void validateCustomer(CustomerModel testData) {
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(testData.getFirstNameValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getFirstNameValue() + "into the table");
        Assert.assertTrue(customerTableRow.contains(testData.getLastNameValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getLastNameValue() + "into the table");
        Assert.assertTrue(customerTableRow.contains(testData.getPostCodeValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getPostCodeValue() + "into the table");
//        Assert.assertTrue(customerTableRow.contains(testData.getAccountNumber()));
    }

    public void deleteCustomer() {
        deletecustomerElement.click();
        LogUtility.infoLog("The user deletes the customer ");
    }
}
