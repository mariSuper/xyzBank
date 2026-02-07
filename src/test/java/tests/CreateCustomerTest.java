package tests;

import models.CustomerModel;
import org.testng.annotations.Test;
import pages.*;
import shareData.ShareData;

public class CreateCustomerTest extends ShareData {

    @Test(groups = {SuiteType.REGRESSION_SUITE, SuiteType.CUSTOMER_SUITE, SuiteType.ACCOUNT_SUITE})
    public void automationTest() {

        CustomerModel customer = new CustomerModel("CustomerData.json");

        //elementul meniu 'Bank Manager Login'   button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        //submeniul 'Add Customer'   button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomerProcess(customer);
        customerPage.openAccount();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.createAccountProcess(customer);
        accountPage.openCustomersPage();
    }
}
