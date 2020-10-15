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
    @Column(name = "id")
    private int id;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "AccountTypeId")
    private String accountTypeId;

    @Column(name = "Currency")
    private String currency;

    @Column(name = "AccountBalance")
    private int accountBalance;

    @Column(name = "FriendlyName")
    private String friendlyName;

    @Column(name = "CustomerId")
    private int customerId;


    public BankAccount() {
    }

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

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
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