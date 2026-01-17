package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.List;

public class CreateCustomerTest {
    public WebDriver driver;

    @Test
    public void automationTest() {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //elementul meniu 'Bank Manager Login'   button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        //submeniul 'Add Customer'   button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

//        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Irina";
//        firstNameElement.sendKeys(firstNameValue);

//        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Retea";
//        lastNameElement.sendKeys(lastNameValue);

//        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "050600";
//        postCodeElement.sendKeys(postCodeValue);

//        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitCustomerElement.click();

//         Alert customerAlert = driver.switchTo().alert();
//        String customerAlertText = customerAlert.getText();
//        System.out.println(customerAlertText);
//        customerAlert.accept();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomerProcess(firstNameValue, lastNameValue, postCodeValue);
        customerPage.openAccount();

        // Open Acount button   button[@ng-click='openAccount()']
//        WebElement openAccountElement = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
//        openAccountElement.click();

        // Write in field customerName   userSelect
//        WebElement customerName = driver.findElement(By.id("userSelect"));
//        Select customerSelect = new Select(customerName);
        String fullNameValue = firstNameValue + " " + lastNameValue;
//        customerSelect.selectByVisibleText(fullNameValue);

        // Choose currency
//        WebElement currency = driver.findElement(By.id("currency"));
//        Select currencySelect = new Select(currency);
        String currencyValue = "Dollar";
//        currencySelect.selectByVisibleText(currencyValue);

        // submit button   button[@type='submit']
//        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitButton.click();

        // get text from the Alert
//        Alert accountAlert = driver.switchTo().alert();
//        String accountAlertText = accountAlert.getText();
//        System.out.println(accountAlertText);
//        String [] accountsArray = accountAlertText.split(":");
//        String accountNumber = accountsArray[1];
//        System.out.println(accountsArray[1]);
//        accountAlert.accept();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAccountProcess(fullNameValue, currencyValue);
        accountPage.openCustomersPage();

        ValidCustomersPage validCustomersPage = new ValidCustomersPage(driver);
        validCustomersPage.searchCustomer(firstNameValue);
        validCustomersPage.validateCustomer(firstNameValue, lastNameValue, postCodeValue);
        validCustomersPage.deleteCustomer();

        //Customers button
//        WebElement customersButton = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
//        customersButton.click();

        //Adaugam un wait fortat care sa ne garanteze ca cele doua componente comunica intre ele
//        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
//        searchCustomerElement.click();
//        searchCustomerElement.sendKeys(firstNameValue);
//
//        List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
//        String customerTableRow = tableRows.get(0).getText();
//        Assert.assertTrue(customerTableRow.contains(firstNameValue));
//        Assert.assertTrue(customerTableRow.contains(lastNameValue));
//        Assert.assertTrue(customerTableRow.contains(postCodeValue));
//        Assert.assertTrue(customerTableRow.contains(accountNumber));
//
//        WebElement deletecustomerElement = driver.findElement(By.xpath("//button[@ng-click='deleteCust(cust)']"));
//        deletecustomerElement.click();
    }
}
