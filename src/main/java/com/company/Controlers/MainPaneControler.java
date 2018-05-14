package com.company.Controlers;

import com.company.Users.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPaneControler implements Initializable {
    @FXML private DatePicker datePicker;
    @FXML private ChoiceBox serviceChoiceBox1;
    @FXML private Button scheduleVisitButton;
    @FXML private Button logoutButton;
    @FXML private Label userNameLable;


    public void serviceChoiceScreenOn(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ScheduleServicePane.fxml")));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    public void logoutButtonAction(ActionEvent event) throws Exception{
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("LoginPane.fxml")));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getClient (Client client){
        userNameLable.setText("Witaj " + client.getName() + " " + client.getSurname());
    }


}