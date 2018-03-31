package com.company;

import com.company.Services.Service;
import com.company.Services.ServiceRepository;

public class Main {

    public static void main(String[] args) {

        Service service1 = new Service("Malowanie lakierem klasycznym", 50.00, 2.00);
        Service service2 = new Service("Malowanie lakierem hybrydowym", 80.00, 1.50);
        Service service3 = new Service("Żele", 100.00, 3.0);


        ServiceRepository.showServices();
//        System.out.println(service1.toString());
//        System.out.println(service2.toString());
//        System.out.println(service3.toString());

    }
}
