package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CustomerPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameElement;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameElement;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitCustomerElement;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    private WebElement openAccountElement;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerElement;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement deletecustomerElement;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void createCustomerProcess(CustomerModel testData){
        firstNameElement.sendKeys(testData.getFirstNameValue());
        lastNameElement.sendKeys(testData.getLastNameValue());
        postCodeElement.sendKeys(testData.getPostCodeValue());
        submitCustomerElement.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();
    }
    public void createCustomersProcess(List<String>firstNameValueList, List<String>lastNameValueList, List<String>postCodeValueList ){
        String fullName = " ";
        int i=0;
        while (i<firstNameValueList.size()){
            firstNameElement.sendKeys(firstNameValueList.get(i));
            lastNameElement.sendKeys(lastNameValueList.get(i));
            postCodeElement.sendKeys(postCodeValueList.get(i));
            submitCustomerElement.click();

            Alert customerAlert = driver.switchTo().alert();
            String customerAlertText = customerAlert.getText();
            System.out.println(customerAlertText);
            customerAlert.accept();
            i++;
        }
    }
    public void openAccount(){
        openAccountElement.click();
    }
    public void searchCustomer (CustomerModel testData){
        searchCustomerElement.click();
        searchCustomerElement.sendKeys(testData.getFirstNameValue());
    }

    public void validateCustomer (CustomerModel testData){
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(testData.getFirstNameValue()));
        Assert.assertTrue(customerTableRow.contains(testData.getLastNameValue()));
        Assert.assertTrue(customerTableRow.contains(testData.getPostCodeValue()));
        Assert.assertTrue(customerTableRow.contains(testData.getAccountNumber()));
    }
    public void deleteCustomer (){
        deletecustomerElement.click();
    }

}
