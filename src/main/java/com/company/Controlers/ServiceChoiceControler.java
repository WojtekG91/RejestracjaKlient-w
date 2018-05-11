package com.company.Controlers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.company.Services.Service;
import com.company.Services.ServiceRepository;
import com.company.Users.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ServiceChoiceControler implements Initializable {

    @FXML
    private ComboBox categoryComboBox;
    @FXML
    private ComboBox categoryComboBox1;
    @FXML
    private ComboBox categoryComboBox11;
    @FXML
    private ComboBox categoryComboBox111;
    @FXML
    private ComboBox serviceComboBox;
    @FXML
    private Button backToMainButton;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ChoiceBox<String> serviceChoiceBox1;
    @FXML
    private Button serviceAddButton;
    @FXML
    private Button serviceAddButton1;
    @FXML
    private Button serviceAddButton11;
    @FXML
    private Label servicePriceLable;
    @FXML
    private Label serviceDurationLable;

    Map<String, String> prices = new HashMap<>();

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //assert serviceChoiceBox1 != null : "fx:id=\"serviceChoiceBox1\" was not injected: check your FXML file 'ScheduleServicePane.fxml'.";
        ServiceRepository serviceRepository = new ServiceRepository();
        categoryComboBox.getItems().setAll("Manicure", "Pedicure", "Lashes");
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (categoryComboBox.getValue().equals("Manicure")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.manicure().size(); i++) {
                        Service service = serviceRepository.manicure().get(i);
                        serviceComboBox.getItems().add(service.getName());
                        prices.put(service.getName(), service.getPrice().toString());
                    }

                } else if (categoryComboBox.getValue().equals("Pedicure")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.pedicure().size(); i++) {
                        serviceComboBox.getItems().add(serviceRepository.pedicure().get(i).getName());
                    }
                } else if (categoryComboBox.getValue().equals("Lashes")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.brwi().size(); i++) {
                        serviceComboBox.getItems().add(serviceRepository.brwi().get(i).getName());
                    }
                }

            }
        });
    }
    class ItemChangerListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED){
                Object item = e.getItem();
                servicePriceLable.setText(prices.get(item.toString()));
            }
        }
    }
    public void backToMainScreen(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("MainPane.fxml"));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}



