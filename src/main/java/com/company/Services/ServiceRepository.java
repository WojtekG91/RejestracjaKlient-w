package com.company.Services;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceRepository {
    static HashMap<Integer, Service> serviceLists = new HashMap<>();

    public static ArrayList<Service> manicure () {
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service("Manicure Klasyczny (z malowaniem lub bez))",40.0, 60));
        services.add(new Service("Manicure Hybrydowy",80.0, 90));
        services.add(new Service("Manicure Hybrydowy French",85.0, 90));
        services.add(new Service("Manicure INFINITSHINE O.P.I.",55.0, 45));
        services.add(new Service("Manicure Japoński",50.0, 60));
        return services;
    }
    public static ArrayList<Service> pedicure () {
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service("Pedicure Leczniczy",130.0, 90));
        services.add(new Service("Pedicure Leczniczy French",105.0, 90));
        services.add(new Service("Pedicure Leczniczy Hybrydowy",150.0, 120));
        services.add(new Service("Pedicure Leczniczy z Kwasami (Callux)",155.0, 90));
        services.add(new Service("Kwasy (Callux)",70.0, 40));
        return services;
    }
    public static ArrayList<Service> brwi () {
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service("Henna Rzęs lub Brwi",25.0, 15));
        services.add(new Service("Regulacja Brwi",20.0, 10));
        services.add(new Service("Regulacja Brwi Woskiem",25.0, 20));
        services.add(new Service("MKomplet – Hena Rzęs i Brwi + Regulacja Brwi",50.0, 30));
        return services;
    }

    public static void addService(Service service) {
        Integer index = serviceLists.size() - 1;
        serviceLists.put(index + 1, service);
    }

    public static void showServices() {
        for (int i = 0; i < serviceLists.size(); i++) {
            System.out.println(serviceLists.get(i).toString());
        }
    }

    public static void deleteService(Integer index) {
        serviceLists.remove(index);
    }

    public String chooseService(Integer index) {
        return serviceLists.get(index).toString();
    }

//    public static void chooseService(Integer index) {
//        System.out.println(serviceLists.get(index).toString());
//    }
}
