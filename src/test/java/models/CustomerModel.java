package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class CustomerModel {

    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private String currencyValue;
    private String fullNameValue;
    private String accountNumber;

    public CustomerModel(String fileName) {
        loadFromJson(fileName);
    }

    private void loadFromJson(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException("Nu gasesc fisierul " + fileName + " in src/test/resources");
            }

            mapper.readerForUpdating(this).readValue(is);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // getters & setters
    public String getFirstNameValue() {
        return firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public String getPostCodeValue() {
        return postCodeValue;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public String getFullNameValue() {
        return fullNameValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}