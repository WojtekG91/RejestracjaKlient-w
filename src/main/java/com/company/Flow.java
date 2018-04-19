package com.company;

import com.company.Services.ServiceRepository;
import com.company.Users.ClientRegistration;
import com.company.Users.Login;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Flow {
    static void Start() {

        System.out.println("What do you want to do:\n" + "1. Login\n" + "2. Register");
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        int Operation = scanner.nextInt();

        switch (Operation) {
            case 1:
                String mail = scanner.nextLine();
                String password = scanner.nextLine();
                login.LoginAtempt(mail, password);
                break;
            case 2:
                ClientRegistration.userRegistration();
                String mailRegistered = scanner.nextLine();
                String passwordRegistered = scanner.nextLine();
                login.LoginAtempt(mailRegistered, passwordRegistered);
                break;
        }


    }
}

