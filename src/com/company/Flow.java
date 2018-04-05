package com.company;

import com.company.Services.ServiceRepository;

import java.util.Scanner;

public class Flow {
    public static void start() {

        String clientLogin = "test"; //predefiniowany login użytkownika
        String clientPassword = "test"; // predefiniowane hasło
        String emplyeeLogin = "master";
        String emplyeePassword = "master";
        Scanner scanner = new Scanner(System.in);
        String enteredLogin, enteredPassword; //definiowanie loginu wprowadzanego przez użytkownika


        boolean loginSucces = false;
        int loginType = 0;

        while (loginSucces != true) {
            System.out.print("Login: ");
            enteredLogin = scanner.nextLine();
            System.out.print("Password: ");
            enteredPassword = scanner.nextLine();

            if (enteredLogin.equals(clientLogin) && enteredPassword.equals(clientPassword)) {
                System.out.println("You're logged in");
                loginSucces = true;
                loginType = 1;
                break;
            } else if (enteredLogin.equals(emplyeeLogin) && enteredPassword.equals(emplyeePassword)) {
                System.out.println("Witaj!!!");
                loginSucces = true;
                loginType = 2;
                break;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }


        switch (loginType) {
            //Klient
            case 1: {
                while (loginType == 1) {
                    System.out.println("jaka usługe chcesz wybrać");
                    ServiceRepository.showServices();
                    ServiceRepository.chooseService(scanner.nextInt());

                    break;
                }
            }
            //Pracownik
            case 2: {
                while (loginType == 2) {
                    System.out.println("co chcesz zrobic??");
                    scanner.nextInt();
                    break;
                }
            }

        }
    }
}
