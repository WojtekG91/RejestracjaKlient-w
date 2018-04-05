package com.company;

import com.company.Services.ServiceRepository;
import com.company.Users.ClientRegistration;

public class Main {

    public static void main(String[] args) {

        ServiceRepository.showServices();


//        Client Ewelina = new Client("Ewelina", "Sanka","66666666");
//        Ewelina.chooseService();

        ClientRegistration.userRegistration();

//        ClientRegistration registration = new ClientRegistration();
//        registration.userRegistration();
//        Flow.start();
    }
}
