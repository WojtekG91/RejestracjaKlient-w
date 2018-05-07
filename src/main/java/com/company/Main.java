package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene loginScene;

    public static void main(String[] args) {
        launch(args);
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

