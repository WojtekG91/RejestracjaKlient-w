package com.company.Users;

import com.company.SQL.InsertSQL;

import java.util.Scanner;

public class ClientRegistration {
        public static void userRegistration() {
        String name, surname, mail, phone, password, password2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imie:");
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        surname = scanner.nextLine();
        System.out.println("Podaj mail");
        mail = scanner.nextLine();
        System.out.println("Podaj numer telefonu");
        phone = scanner.nextLine();

        boolean passwordCheack = false;
        do {
            System.out.println("Podaj hasło");
            password = scanner.nextLine();
            System.out.println("Wprowadź ponownie hasło");
            password2 = scanner.nextLine();
            if (password.equals(password2)) {
                System.out.println("Poprawne");
                passwordCheack = true;
                InsertSQL.registrationStatement(name, surname, mail, phone, password);
            } else {
                System.out.println("Hasła sie nie zgadzają");
            }
        } while (passwordCheack == false);


    }
}
