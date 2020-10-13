package hibernate.customer;
import hibernate.bank_account.BankAccount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;
    private String FirstName;
    private String LastName;
    private String CNP;
    private String Email;
    private String Username;
    private String Password;

    //    public List<BankAccount> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<BankAccount> children) {
//        this.children = children;
//    }

    public Customer() {
    }

    public void setCustomerId(Long CustomerId) {
        this.CustomerId = CustomerId;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public String getCNP() {
        return CNP;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CNP=" + CNP +
                ", CustomerId=" + CustomerId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
