package com.company.Users;

import com.company.SQL.SQLStatements;

import java.util.Scanner;

public class ClientRegistration {


    public static void userRegistration() {
        MailVerification mailVerification = new MailVerification();
        String name, surname, mail, phone, password, passwordVerification;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie:");
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        surname = scanner.nextLine();

        boolean mailCheck = false;
        System.out.println("Podaj mail");
        do {
            mail = scanner.nextLine();
            if (mailVerification.validate(mail)) {
                mailCheck = true;
            } else {
                System.out.println("Niepoprawny email, spróbuj ponownie");
            }
        } while (mailCheck == false);

        System.out.println("Podaj numer telefonu");
        phone = scanner.nextLine();

        boolean passwordCheack = false;
        do {
            System.out.println("Podaj hasło");
            password = scanner.nextLine();
            System.out.println("Wprowadź ponownie hasło");
            passwordVerification = scanner.nextLine();
            if (password.equals(passwordVerification)) {
                System.out.println("Poprawne");
                passwordCheack = true;
                Hashing hashing = new Hashing();
                password = hashing.HashingPassword(password);
                SQLStatements.registrationStatement(name, surname, mail, phone, password);
            } else {
                System.out.println("Hasła sie nie zgadzają");
            }
        } while (passwordCheack == false);


    }
}
