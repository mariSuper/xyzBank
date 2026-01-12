package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CreateCustomersTest {
    public WebDriver driver;

    @Test
    public void automationTest() {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //elementul meniu 'Bank Manager Login' button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        //submeniul 'Add Customer' button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

        List<String> firstNameValueList = Arrays.asList("Irina1", "Irina2", "Irina3");
        List<String> lastNameValueList = Arrays.asList("Retea1", "Retea2", "Retea3");
        List<String> postCodeValueList = Arrays.asList("050605", "050606", "050607");
        String fullName = " ";

        int i=0;
        while (i<firstNameValueList.size()){
            WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            firstNameElement.sendKeys(firstNameValueList.get(i));

            WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            lastNameElement.sendKeys(lastNameValueList.get(i));

            WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
            postCodeElement.sendKeys(postCodeValueList.get(i));

            WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
            submitCustomerElement.click();

            Alert customerAlert = driver.switchTo().alert();
            String customerAlertText = customerAlert.getText();
            System.out.println(customerAlertText);
            customerAlert.accept();

            fullName = firstNameValueList.get(i)+ " " + lastNameValueList.get(i);
            i++;
        }
    }
}
