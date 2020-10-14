package view;

import hibernate.bank_account.BankAccount;
import hibernate.customer.Customer;
import hibernate.customer.CustomerDao;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public void welcomeMenu(){
        System.out.println("1. Register");
        System.out.println("2. Login");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:
                registration();
                break;
            case 2:
                login();
                break;
        }
        if (option == 1) {
            welcomeMenu();
        }
    }

    public void registration(){
        Scanner input = new Scanner(System.in);
        System.out.println("Dati primul nume de inregistrare");
        String firstName = input.nextLine();
        System.out.println("Dati nume al doilea nume de inregistrare");
        String secondName = input.nextLine();
        // la username unic verificam daca username-ul exista deja sau incercam direct sa cream
        // userul si daca ne da eroare(il punem in baza de date field unic) anuntam userul ?
        //metoda de verifcare unicitate username ?
        System.out.println("Dati usernameul ");
        String username = input.nextLine();

        System.out.println("Dati password");
        String password = input.nextLine();
        CustomerDao customerDao = new CustomerDao();
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(secondName);
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);

        try {
            customerDao.createCustomer(newCustomer);
            System.out.println("Registration successful");
        }catch (Exception e){
            System.out.println("ceva eraore la creare customer");
            e.printStackTrace();
        }

    }
    public void login(){
        CustomerDao customerDao = new CustomerDao();

        System.out.println("Introduceti username");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        System.out.println("Introduceti parola");
        String password  = input.nextLine();

        Customer customerData = customerDao.findByUsername(username);
        System.out.println("Sa vad ce gaseste :" +customerData);
        if(customerData == null || !password.equals(customerData.getPassword())){
            System.out.println("Date introduse gresit, incercati din nou");
            login();
        }else {
            welcomeMenuLoggedIn(customerDao,customerData);
        }
    }
    // cand facem apelurile sa trimitem si customerDao ca si parametru sau sa il cream din nou in
    // metoda in care il folosim ?
    public void welcomeMenuLoggedIn(CustomerDao customerDao, Customer customer) {
        System.out.println(" 1 View portofolio\n 2.Transfer money ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        Ana ana = new Ana();
        Liviu liviu = new Liviu();
        Adian adian = new Adian();


        switch (option) {
            case 1:
                ///viewPortofolio(customer);
                //viewBalance;
                //ana.viewPortofolio;
                break;
            case 2:
                //transferMoney(customer);
                break;
        }
    }

}
