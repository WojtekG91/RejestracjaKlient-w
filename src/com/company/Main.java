package com.company;

import com.company.Services.Service;
import com.company.Services.ServiceRepository;
import com.company.Users.Client;

public class Main {

    public static void main(String[] args) {

        Service service1 = new Service("Malowanie lakierem klasycznym", 50.00, 2.00);
        Service service2 = new Service("Malowanie lakierem hybrydowym", 80.00, 1.50);
        Service service3 = new Service("Żele", 100.00, 3.0);
        Service service4 = new Service("Żele 21", 110.00, 3.0);

        System.out.println("---------------------------");
        ServiceRepository.addService(service1);
        ServiceRepository.addService(service2);
        ServiceRepository.addService(service3);
        ServiceRepository.addService(service4);


        ServiceRepository.showServices();


        Client Ewelina = new Client("Ewelina", "Sanka","66666666");
        Ewelina.chooseService(1);


        Flow.start();
    }
}
