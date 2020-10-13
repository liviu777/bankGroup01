package hibernate.account_type;


import hibernate.bank_account.BankAccount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AccountType")
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long accountId;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    // owning side
    /*@OneToMany(
            mappedBy = "account_type",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BankAccount> BankAccountList = new ArrayList<>();*/

    public AccountType() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBankAccountId() {
        return accountNumber;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.accountNumber = bankAccountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /*public List<BankAccount> getBankAccountList() {
        return BankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        BankAccountList = bankAccountList;
    }*/

    @Override
    public String toString() {
        return "AccountType{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", BankAccountList=" + //BankAccountList +
                '}';
    }
}
