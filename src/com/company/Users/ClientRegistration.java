package com.company.Users;

import java.sql.*;
import java.util.Scanner;

public class ClientRegistration {
    String name, surname, mail, phone, password, password2;

    public String userRegistration() {
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
            } else {
                System.out.println("Hasła sie nie zgadzają");
            }
        } while (passwordCheack = false);

        Connection connect = null;

        PreparedStatement preparedStatement = null;

        // This will load the MySQL driver, each DB has its own driver


        try {

            String sqlInsert = "INSERT INTO `Tclients`(`Name`, `Surname`, `Email`, `Phone`, `Password`)" + "VALUES (?, ?, ?, ?, ?,?);";

            preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, mail);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "Registration succesfull";
    }
}
