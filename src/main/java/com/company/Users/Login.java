package com.company.Users;

import com.company.SQL.SQLStatements;

public class Login {
    private String mail, password;
    private Hashing hashing = new Hashing();

    public void LoginAtempt(String mail, String password) {
        String dbPassword = SQLStatements.getSqlPassword(mail);
        boolean mailCheck = SQLStatements.getSqlMail(mail);
        if (mailCheck) {
            password = hashing.HashingPassword(password);
            if (dbPassword.equals(password)) {
                System.out.println("Logowanie udane");
            } else {
                System.out.println("Niepoprawny email lub hasło");
            }
        } else {
            System.out.println("no user with this mail");
        }
    }
}
