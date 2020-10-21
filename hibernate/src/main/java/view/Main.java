package view;

import hibernate.account_type.AccountType;
import hibernate.account_type.AccountTypeDao;
import tests.EntityDaoTests;

public class Main {
    public static void main(String[] args) {
        //am mutat in fisierul asta toate testele pentru DAO entitati ca sa fie main-ul mai curat




        MainMenu mainMenu = new MainMenu();
        mainMenu.welcomeMenu();

        //Liviu liviu = new Liviu();
        //liviu.transferMoney();
        //liviu.createDebitAccount();

        //Ana ana = new Ana();
        //ana.viewPortofolio();
        //ana.depositATM();
        //ana.createCreditAccount();

        //EntityDaoTests.test();
    }
}
