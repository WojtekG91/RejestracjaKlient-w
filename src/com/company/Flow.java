package com.company;

import java.util.Scanner;

public class Flow {
    public static void start() {

        String clientLogin = "test"; //predefiniowany login
        String clientPassword = "test"; // predefiniowane hasło
        String emplyeeLogin = "master";
        String emplyeePassword = "master";
        Scanner scanner = new Scanner(System.in);
        String enteredLogin, enteredPassword; //definiowanie loginu wprowadzanego przez użytkownika


        boolean loginSucces = false;
        while (loginSucces != true) {
            System.out.print("Login: ");
            enteredLogin = scanner.nextLine();
            System.out.print("Password: ");
            enteredPassword = scanner.nextLine();

            if (enteredLogin.equals(clientLogin) && enteredPassword.equals(clientPassword)) {
                System.out.println("You're logged in");
                loginSucces = true;
            } else if (enteredLogin.equals(emplyeeLogin) && enteredPassword.equals(emplyeePassword)) {
                System.out.println("Witaj!!!");
                loginSucces = true;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }

    }
}
