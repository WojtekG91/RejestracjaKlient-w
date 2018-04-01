package com.company.Services;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceRepository {
    public static HashMap<Integer, Service> serviceLists = new HashMap<>();


    public static void addService(Service service) {
        Integer index = serviceLists.size() - 1;
        serviceLists.put(index + 1, service);
    }

    public static void showServices() {
        for (int i = 0; i < serviceLists.size(); i++) {
            System.out.println("Service no: " + i + " " + serviceLists.get(i));
        }
    }

    public static void deleteService(Integer index) {
        serviceLists.remove(index);
    }

    public static void chooseService(Integer index) {
        serviceLists.get(index).toString();
            }

//    public static void chooseService(Integer index) {
//        System.out.println(serviceLists.get(index).toString());
//    }
}
