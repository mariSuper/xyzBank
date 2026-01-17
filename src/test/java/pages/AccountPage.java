package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.logging.XMLFormatter;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "userSelect")
    public WebElement customerName;

    @FindBy(id = "currency")
    public WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement customersButton;

    public void createAccountProcess(String fullNameValue, String currencyValue){

        // Write in field customerName   userSelect
        Select customerSelect = new Select(customerName);
        customerSelect.selectByVisibleText(fullNameValue);

        // Choose currency
        Select currencySelect = new Select(currency);
        currencySelect.selectByVisibleText(currencyValue);

        // submit button   button[@type='submit']
        submitButton.click();

        // get text from the Alert
        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        System.out.println(accountsArray[1]);
        accountAlert.accept();
    }
    public void openCustomersPage(){
        customersButton.click();
    }
}
