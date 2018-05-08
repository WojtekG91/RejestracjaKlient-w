package com.company;

import com.company.Services.Service;
import com.company.Services.ServiceListGenerator;
import com.company.Services.ServiceRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;


public class Main extends Application {

    Stage window;
    Scene loginScene;

    public static void main(String[] args) {
        launch(args);
        ServiceRepository.showServices();
        Service service = new Service("Malowanie", 30.20,2.3);
        Service service1 = new Service("Malowanie lakierem klasycznym", 50.00, 2.00);
        Service service2 = new Service("Malowanie lakierem hybrydowym", 80.00, 1.50);
        Service service3 = new Service("Żele", 100.00, 3.0);
        Service service4 = new Service("Żele 21", 110.00, 3.0);
        Service service5 = new Service("test",200.0,2.0);
        ServiceRepository.addService(service);
        ServiceRepository.addService(service1);
        ServiceRepository.addService(service2);
        ServiceRepository.addService(service3);
        ServiceRepository.addService(service4);
        ServiceRepository.addService(service5);
        ServiceRepository.showServices();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("LoginPane.fxml"));
        Pane pane = loader.load();
        loginScene = new Scene(pane);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("System Rejestracji");
        primaryStage.show();

    }
}

