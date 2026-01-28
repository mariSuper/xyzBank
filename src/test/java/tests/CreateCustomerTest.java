package tests;
import models.CustomerModel;
import org.testng.annotations.Test;
import pages.*;
import shareData.ShareData;

public class CreateCustomerTest extends ShareData {

    @Test
    public void automationTest() {
        CustomerModel testData = new CustomerModel("C:\\LUCRU\\QA_cursss\\xyzBankATF\\src\\test\\resources\\CustomerData.json");

        //elementul meniu 'Bank Manager Login'   button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        //submeniul 'Add Customer'   button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomerProcess(testData);
        customerPage.openAccount();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAccountProcess(testData);
        accountPage.openCustomersPage();
    }
}
