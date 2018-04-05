package com.company.Users;


import com.company.Services.Service;
import com.company.Services.ServiceRepository;

import java.util.Scanner;

public class Client extends Person {
    private int noOfVisits;
    private int paidForService;


    public Client(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    public static void chooseService(){
        System.out.println("Prosze wybrac usługę:");
        ServiceRepository.showServices();
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        ServiceRepository.chooseService(n);

    }

    public int getNoOfVisits() {
        return noOfVisits;
    }

    public void setNoOfVisits(int noOfVisits) {
        this.noOfVisits++;
    }

    public int getPaidForService() {
        return paidForService;
    }

    public void setPaidForService(int paidForService) {
        this.paidForService += paidForService;
    }
}
