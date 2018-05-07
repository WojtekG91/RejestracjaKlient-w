package com.company.Users;

import com.company.SQL.SQLStatements;

public class ClientRegistration {


    public String userRegistration(String name, String surname, String mail, String phone, String password, String passwordVerification) {
        MailVerification mailVerification = new MailVerification();
        boolean mailCheck = false;
        if (mailVerification.validate(mail)) {
            mailCheck = true;
        } else {
            return "Niepoprawny email, spróbuj ponownie";
        }
        boolean passwordCheack = false;

            if (password.equals(passwordVerification)) {
                passwordCheack = true;
                Hashing hashing = new Hashing();
                password = hashing.HashingPassword(password);
                SQLStatements.registrationStatement(name, surname, mail, phone, password);
            } else {
                return "Niezgodne hasła";
            }

        return "Registration succesfull";
    }
}
