package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerPage;
import shareData.ShareData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest extends ShareData {

    @Test(groups = {SuiteType.REGRESSION_SUITE, SuiteType.ACCOUNT_SUITE})
    public void automationTest() {

          //elementul meniu Bank Manager Login button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();

        //submeniul 'Add Customer' button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

        WebElement firstNameElement = getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Irina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Retea";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = getDriver().findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "050600";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitCustomerElement.click();

        Alert customerAlert = getDriver().switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = getDriver().findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();

        //Vreau sa creez 3 conturi pentru un customer
        List<String> currencyValuesList = Arrays.asList("Dollar", "Pound", "Rupee");
        String fullNameValue = firstNameValue+ " " + lastNameValue;

        for (int i=0; i<currencyValuesList.size(); i++){

            WebElement customerName = getDriver().findElement(By.id("userSelect"));
            Select customerSelect = new Select(customerName);

            customerSelect.selectByVisibleText(fullNameValue);

            WebElement currency = getDriver().findElement(By.id("currency"));
            Select currencySelect = new Select(currency);
            currencySelect.selectByVisibleText(currencyValuesList.get(i));

            WebElement processButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
            processButton.click();

            Alert accountAlert = getDriver().switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();
        }
        WebElement customersButton = getDriver().findElement(By.xpath("//button[@ng-click='showCust()']"));
        customersButton.click();

        WebElement searchCustomerElement = getDriver().findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.sendKeys(fullNameValue);
    }
}
