package com.company.Controlers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class MainPaneControler {
    @FXML private DatePicker datePicker;
    @FXML private ChoiceBox serviceChoiceBox1;
    @FXML private Button scheduleVisitButton;
    @FXML private Button logoutButton;


    public void serviceChoiceScreenOn(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ScheduleServicePane.fxml"));
        Parent root1 = /*(Parent)*/ fxmlLoader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    public void logoutButtonAction(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("LoginPane.fxml"));
        Parent root1 = /*(Parent)*/ fxmlLoader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}