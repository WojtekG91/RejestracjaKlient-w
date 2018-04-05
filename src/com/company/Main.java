package com.company;

import com.company.SQL.InsertSQL;
import com.company.SQL.SqlConnection;
import com.company.Services.ServiceRepository;
import com.company.Users.Client;
import com.company.Users.ClientRegistration;

public class Main {

    public static void main(String[] args) {

        ServiceRepository.showServices();


//        Client Ewelina = new Client("Ewelina", "Sanka","66666666");
//        Ewelina.chooseService();

        InsertSQL.registrationStatement(1,"Ewelina", "Sańka", "awdas@sdasd", "3123123123", "dafdfsa");

//        ClientRegistration registration = new ClientRegistration();
//        registration.userRegistration();
//        Flow.start();
    }
}
