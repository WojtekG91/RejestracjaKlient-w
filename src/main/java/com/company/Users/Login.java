package com.company.Users;

import com.company.SQL.SQLStatements;
import com.company.SQL.SqlConnection;

public class Login {
    private Hashing hashing = new Hashing();

    public boolean LoginAtempt(String mail, String password) {
       SQLStatements sqlStatements = new SQLStatements();
       sqlStatements.getClient(mail);
//        boolean mailCheck = SQLStatements.getSqlMail(mail);
        System.out.println(sqlStatements.getClient(mail).getPasswordHash());
        System.out.println(sqlStatements.getClient(mail).getName());
        System.out.println(sqlStatements.getClient(mail).getSurname());
        System.out.println(sqlStatements.getClient(mail).getPhone());
        System.out.println(sqlStatements.getClient(mail).getMail());
        if ((sqlStatements.getClient(mail).getMail()).equals(hashing.HashingPassword(password))) {
            return true;
        } else {
            return false;
        }
    }
}
