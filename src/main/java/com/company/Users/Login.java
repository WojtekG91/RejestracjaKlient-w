package com.company.Users;

import com.company.SQL.SQLStatements;
import com.company.SQL.SqlConnection;

public class Login {
    private Hashing hashing = new Hashing();

    public boolean LoginAtempt(String mail, String password) {
        SQLStatements sqlStatements = new SQLStatements();
        sqlStatements.getClient(mail);
//        boolean mailCheck = SQLStatements.getSqlMail(mail);
        if ((sqlStatements.getClient(mail).getPasswordHash()).equals(hashing.HashingPassword(password))) {
            return true;
        } else {
            return false;
        }
    }
}
