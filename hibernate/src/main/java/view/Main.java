package view;

import tests.EntityDaoTests;

public class Main {
    public static void main(String[] args) {
        //am mutat in fisierul asta toate testele pentru DAO entitati ca sa fie mainl mai curat
        MainMenu mainMenu = new MainMenu();
        mainMenu.welcomeMenu();
        //EntityDaoTests.test();
    }
}
