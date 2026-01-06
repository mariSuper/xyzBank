package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest {
    public WebDriver driver;

    @Test

    public void automationTest() {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //button[@ng-click='addCust()']
        WebElement bankManagerElement = driver.findElement(By.xpath("//button[@ng-click='manager()']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Irina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Retea";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "050600";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
        submitCustomerElement.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();

        //Vreau sa creez 3 conturi pentru un customer
        List<String> currencyValuesList = Arrays.asList("Dollar", "Pound", "Rupee");
        String fullNameValue = firstNameValue+ " " + lastNameValue;

        for (int i=0; i<currencyValuesList.size(); i++){

            WebElement customerName = driver.findElement(By.id("userSelect"));
            Select customerSelect = new Select(customerName);

            customerSelect.selectByVisibleText(fullNameValue);

            WebElement currency = driver.findElement(By.id("currency"));
            Select currencySelect = new Select(currency);
            currencySelect.selectByVisibleText(currencyValuesList.get(i));

            WebElement processButton = driver.findElement(By.xpath("//button[@type='submit']"));
            processButton.click();

            Alert accountAlert = driver.switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();
        }
        WebElement customersButton = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customersButton.click();

        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.sendKeys(fullNameValue);
    }
}
