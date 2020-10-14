package hibernate.account_type;

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
