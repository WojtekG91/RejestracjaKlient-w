package com.company.Services;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceRepository {
    static HashMap<Integer, Service> serviceLists = new HashMap<>();


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
