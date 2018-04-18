package com.company.Users;

import com.company.SQL.SQLStatements;

public class Login {
    private String mail, password;
    Hashing hashing = new Hashing();
    public void LoginAtempt(String mail, String password){
        String dbPassword = SQLStatements.loginStatement(mail);
        password=hashing.HashingPassword(password);
        if (dbPassword.equals(password)){
            System.out.println("Logowanie udane");
        }else {
            System.out.println("Niepoprawny email lub hasło");
        }
    }
}
