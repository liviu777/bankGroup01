package hibernate.bank_account;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "BankAccount")
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @Column(name = "AccountNumber")
    private String AccountNumber;

    @Column(name = "IBAN")
    private String IBAN;

    @Column(name = "Currency")
    private int Currency;

    @Column(name = "AccountBalance")
    private int AccountBalance;

    @Column(name = "CustomerId")
    private int CustomerId;

    @Column(name = "FriendlyName")
    private String FriendlyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public int getCurrency() {
        return Currency;
    }

    public void setCurrency(int currency) {
        Currency = currency;
    }

    public int getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        AccountBalance = accountBalance;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getFriendlyName() {
        return FriendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        FriendlyName = friendlyName;
    }

    @Override
    public String toString() {
        String BankAccount;
        return "BankAccount{" +
                "id=" + id +
                ", name='" + id + '\'' +
                '}';
    }
}
