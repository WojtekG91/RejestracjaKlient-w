package com.company.Users;

import java.util.Scanner;

public class Client extends Person {
    private int noOfVisits;
    private int paidForService;
    private String passwordHash, mail;
    private int clientId;

    public Client(Integer clientId, String name, String surname, String phone, String passwordHash, String mail) {
        super(name, surname, phone);
        this.passwordHash = passwordHash;
        this.mail = mail;
        this.clientId = clientId;
    }

    public static void chooseService() {
        System.out.println("Prosze wybrac usługę:");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

    }

    public int getClientId() {
        return clientId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getMail() {
        return mail;
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
