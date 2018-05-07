package com.company.Controlers;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.Services.ServiceList;
import com.company.Services.ServiceRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ServiceChoiceControler {

    @FXML
    private Button backToMainButton;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ChoiceBox<String> serviceChoiceBox1;
    @FXML
    void initialize() {
        assert serviceChoiceBox1 != null : "fx:id=\"serviceChoiceBox1\" was not injected: check your FXML file 'ScheduleServicePane.fxml'.";
        ServiceRepository serviceRepository = new ServiceRepository();
        serviceChoiceBox1.setValue(serviceRepository.chooseService(0));

        serviceChoiceBox1.getItems().add("Banana");
        serviceChoiceBox1.getItems().add("Lemon");
    }
    public void backToMainScreen(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPane.fxml"));
        Parent root1 = /*(Parent)*/ fxmlLoader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
}


