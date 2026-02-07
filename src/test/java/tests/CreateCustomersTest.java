package tests;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import shareData.ShareData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomersTest extends ShareData {
//    CustomerModel testData = new CustomerModel("CustomerData.json");

    @Test(groups = {SuiteType.REGRESSION_SUITE, SuiteType.CUSTOMER_SUITE})
    public void automationTest() {
//        CustomerModel testData = new CustomerModel("CustomerData.json");

        //elementul meniu 'Bank Manager Login' button[@ng-click='addCust()']
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        //submeniul 'Add Customer' button[@ng-click='addCust()']
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

        List<String> firstNameValueList = Arrays.asList("Irina1", "Irina2", "Irina3");
        List<String> lastNameValueList = Arrays.asList("Retea1", "Retea2", "Retea3");
        List<String> postCodeValueList = Arrays.asList("050605", "050606", "050607");

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.createCustomersProcess(firstNameValueList, lastNameValueList, postCodeValueList);
    }
}
