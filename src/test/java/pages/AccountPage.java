package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.LogUtility;

public class AccountPage extends BasePage {

    @FindBy(id = "userSelect")
    private WebElement customerName;

    @FindBy(id = "currency")
    private WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement customersButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public void createAccountProcess(CustomerModel testData){
        // Write in field customerName   userSelect
        Select customerSelect = new Select(customerName);
        customerSelect.selectByVisibleText(testData.getFullNameValue());
        LogUtility.infoLog("The user selects "+ testData.getFullNameValue() + "Value from dropdown");

        // Choose currency
        Select currencySelect = new Select(currency);
        currencySelect.selectByVisibleText(testData.getCurrencyValue());
        LogUtility.infoLog("The user selects "+ testData.getCurrencyValue() + "Value from dropdown");

        // submit button   button[@type='submit']
        submitButton.click();
        LogUtility.infoLog("The user clicks on Process Button");

        // get text from the Alert
        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        accountAlert.accept();
        LogUtility.infoLog("The user accepts the account creation alert");
    }
        // click on Customers Page
    public void openCustomersPage(){
        customersButton.click();
        LogUtility.infoLog("The user clicks on Customers Page");
    }
}
