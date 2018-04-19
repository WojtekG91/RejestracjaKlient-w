package com.company.Services;

public class ServiceList {

    private static void generatingServiceList() {
        Service service1 = new Service("Malowanie lakierem klasycznym", 50.00, 2.00);
        Service service2 = new Service("Malowanie lakierem hybrydowym", 80.00, 1.50);
        Service service3 = new Service("Żele", 100.00, 3.0);
        Service service4 = new Service("Żele 21", 110.00, 3.0);
        Service service5 = new Service("test",200.0,2.0);

        ServiceRepository.addService(service1);
        ServiceRepository.addService(service2);
        ServiceRepository.addService(service3);
        ServiceRepository.addService(service4);
        ServiceRepository.addService(service5);
    }
}
