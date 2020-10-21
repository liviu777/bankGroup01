package view;

import hibernate.bank_account.BankAccount;
import hibernate.customer.Customer;
import hibernate.customer.CustomerDao;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//metoda 2 si 4 Liviu

public class MainMenu {

    public void welcomeMenu(){
        System.out.println("Select  option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        Scanner input = new Scanner(System.in);
        int option = 0;
        try {
            option = input.nextInt();
        }catch (Exception e){
            //System.out.println("Selected option doesn't exist");
            System.out.println(e.getMessage());
        }
        switch (option) {
            case 0:
                System.out.println("Option chosen doesn't exist");
                welcomeMenu();
                break;
            case 1:
                registration();
                welcomeMenu();
                break;
            case 2:
                login();
                break;




        }
    }

    public void registration(){
        CustomerDao customerDao = new CustomerDao();
        Scanner input = new Scanner(System.in);
        RegistrationDataValidation registrationDataValidation = new RegistrationDataValidation();
        System.out.println("Enter first name: ");
        String firstName = input.nextLine();
        while (!registrationDataValidation.firstNameValidation(firstName)){
            System.out.println("First name not valid, enter first name again: ");
            firstName = input.nextLine();
        }

        System.out.println("Enter second name: ");
        String secondName = input.nextLine();
        while (!registrationDataValidation.secondNameValidation(secondName)){
            System.out.println("Second name not valid, enter second name again: ");
            secondName = input.nextLine();
        }

        System.out.println("Enter CNP: ");
        String CNP = input.nextLine();
        while (!registrationDataValidation.CNPValidation(CNP)){
            System.out.println("CNP not valid, enter CNP again: ");
            CNP = input.nextLine();
        }

        System.out.println("Enter email: ");
        String email = input.nextLine();

        System.out.println("Enter username: ");
        String username = input.nextLine();
        while (customerDao.findByUsername(username) != null){
            System.out.println("Username exists, choose another username :");
            username = input.nextLine();
        }

        System.out.println("Enter password: ");
        String password = input.nextLine();

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(secondName);
        newCustomer.setCNP(CNP);
        newCustomer.setEmail(email);
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);



        try {
            customerDao.createCustomer(newCustomer);
            System.out.println("Registration successful");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void login(){
        CustomerDao customerDao = new CustomerDao();

        System.out.println("Introduce username: ");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();

        System.out.println("Introduce password: ");
        String password  = input.nextLine();

        Customer customerData = customerDao.findByUsername(username);
        if(customerData == null || !password.equals(customerData.getPassword())){
            System.out.println("Wrong data, try again :");
            login();
        }else {
            welcomeMenuLoggedIn(customerDao,customerData);
        }
    }
    public void welcomeMenuLoggedIn(CustomerDao customerDao, Customer customer) {
        System.out.println("Choose option: ");
        System.out.println(" 1.View portofolio\n 2.Transfer money \n 3.Deposit Cash\n 4.Create " +
                "debit account \n 5.Create credit account");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        Ana ana = new Ana();
        Liviu liviu = new Liviu();
        Adian adian = new Adian();


        switch (option) {
            case 1: ana.viewPortofolio();

                // view portofolio // view balance;
                //bankAccount.viewPortofolio();
                //bankAccount.viewBalance();

                break;
            case 2: liviu.transferMoney();

                break;
            case 3: ana.depositATM(1000);

                //deposit cash at ATM;
//                try {
//                    bankAccount.makeDeposit();
//                } catch (DepositException e){}


                break;
            case 4: liviu.createDebitAccount();

                break;
            case 5:ana.createCreditAccount();

                //create credit account;
                //accountType.createCreditAccount();


        }
    }
}
