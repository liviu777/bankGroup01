package hibernate.bank_account;

import hibernate.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "BankAccount")

@Table(name = "BankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private int id;

    @Column(name = "AccountNumber", unique = true)
    private String accountNumber;

    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "AccountTypeId")
    private int accountTypeId;

    @Column(name = "Currency")
    private String currency;

    @Column(name = "AccountBalance")
    private double accountBalance;

    @Column(name = "FriendlyName")
    private String friendlyName;

    @Column(name = "CustomerId")
    private int customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", accountTypeId='" + accountTypeId + '\'' +
                ", currency='" + currency + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", friendlyName='" + friendlyName + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}