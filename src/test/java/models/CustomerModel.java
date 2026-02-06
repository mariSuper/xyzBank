package models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerModel {
    private String firstNameValue;
    private String lastNameValue;
    private String postCodeValue;
    private String currencyValue;
    private String fullNameValue;
    private String accountNumber;

    // incarca acel fisier
    // citeste datele din el
    // extrage valorile din el
    // si valorile pe care le-am extras
    // trebuie sa le dau ca parametrii mai jos

    public CustomerModel(String fileName) {
        loadFromJson(fileName);
    }

    public void loadFromJson(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(this)
                    .readValue(
                            getClass()
                                    .getClassLoader()
                                    .getResourceAsStream(fileName)
                    );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // getters & setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getFirstNameValue() {
        return firstNameValue;
    }
    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }
    public String getLastNameValue() {
        return lastNameValue;
    }
    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }
    public String getPostCodeValue() {
        return postCodeValue;
    }
    public void setPostCodeValue(String postCodeValue) {
        this.postCodeValue = postCodeValue;
    }
    public String getCurrencyValue() {
        return currencyValue;
    }
    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getFullNameValue() {
        return fullNameValue;
    }
    public void setFullNameValue(String fullNameValue) {
        this.fullNameValue = fullNameValue;
    }
}
