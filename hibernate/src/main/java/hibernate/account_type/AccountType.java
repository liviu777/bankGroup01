package hibernate.account_type;

import hibernate.bank_account.BankAccount;

import javax.persistence.*;

@Entity(name = "AccountType")
@Table(name = "AccountType")
public class AccountType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountTypeId")
    private Long accountTypeId;

    @Column(name = "AccountType")
    private String accountType;

/*    @OneToOne(mappedBy = "accountType",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private BankAccount bankAccount;*/

    public AccountType() {
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
