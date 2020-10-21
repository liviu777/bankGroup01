package hibernate.bank_account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "BankAccount")

@Table(name = "BankAccount")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "AccountNumber", unique = true)
    private int accountNumber;

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

    public BankAccount() {
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
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

    @Override
    public String toString() {
        return "BankAccount{" +
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