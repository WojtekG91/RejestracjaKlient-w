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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ServiceChoiceControler implements Initializable {

    @FXML
    private ComboBox categoryComboBox;
    @FXML
    private ComboBox categoryComboBox1;
    @FXML
    private ComboBox categoryComboBox2;
    @FXML
    private ComboBox categoryComboBox3;
    @FXML
    private ComboBox serviceComboBox;
    @FXML
    private ComboBox serviceComboBox1;
    @FXML
    private ComboBox serviceComboBox2;
    @FXML
    private ComboBox serviceComboBox3;
    @FXML
    private Button backToMainButton;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ChoiceBox<String> serviceChoiceBox1;
    @FXML
    private Label servicePriceLabel;
    @FXML
    private Label serviceDurationLabel;
    @FXML
    private HBox serviceHBox1;
    @FXML
    private HBox serviceHBox2;
    @FXML
    private HBox serviceHBox3;
    @FXML
    private Button removeServiceButton;
    @FXML
    private Button addAnotherServiceButton;

        private Map<String, String> prices = new HashMap<>();
    private Map<String, String> duration = new HashMap<>();
    ArrayList<HBox> hBoxes = new ArrayList<>();
    ArrayList<ComboBox> categoryComboBoxes = new ArrayList<>();
    ArrayList<ComboBox> serviceComboBoxes = new ArrayList<>();
    ServiceRepository serviceRepository = new ServiceRepository();
    ComboBoxPopulation comboBoxPopulation = new ComboBoxPopulation();

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //assert serviceChoiceBox1 != null : "fx:id=\"serviceChoiceBox1\" was not injected: check your FXML file 'ScheduleServicePane.fxml'.";

        hBoxes.add(serviceHBox1);
        hBoxes.add(serviceHBox2);
        hBoxes.add(serviceHBox3);
        categoryComboBoxes.add(categoryComboBox);
        categoryComboBoxes.add(categoryComboBox1);
        categoryComboBoxes.add(categoryComboBox2);
        categoryComboBoxes.add(categoryComboBox3);
        serviceComboBoxes.add(serviceComboBox);
        serviceComboBoxes.add(serviceComboBox1);
        serviceComboBoxes.add(serviceComboBox2);
        serviceComboBoxes.add(serviceComboBox3);

        categoryComboBox.getItems().setAll("Manicure", "Pedicure", "Lashes");
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                comboBoxPopulation.comboBoxFill(categoryComboBox, serviceComboBox, serviceRepository);
                if (categoryComboBox.getValue().equals("Manicure")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.manicure().size(); i++) {
                        Service service = serviceRepository.manicure().get(i);
                        serviceComboBox.getItems().add(service.getName());
                        prices.put(service.getName(), service.getPrice().toString());
                        duration.put(service.getName(), service.getDuration().toString());
                    }
                } else if (categoryComboBox.getValue().equals("Pedicure")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.pedicure().size(); i++) {
                        Service service = serviceRepository.pedicure().get(i);
                        serviceComboBox.getItems().add(service.getName());
                        prices.put(service.getName(), service.getPrice().toString());
                        duration.put(service.getName(), service.getDuration().toString());
                    }
                } else if (categoryComboBox.getValue().equals("Lashes")) {
                    serviceComboBox.getItems().clear();
                    for (int i = 0; i < serviceRepository.brwi().size(); i++) {
                        Service service = serviceRepository.brwi().get(i);
                        serviceComboBox.getItems().add(service.getName());
                        prices.put(service.getName(), service.getPrice().toString());
                        duration.put(service.getName(), service.getDuration().toString());
                    }
                }
            }
        });
    }


    public void comboAction(ActionEvent event) {
        servicePriceLabel.setText(prices.get(serviceComboBox.getValue()) + " PLN");
        serviceDurationLabel.setText(duration.get(serviceComboBox.getValue()) + " min");
    }

    private int i = 0;

    public void addAnotherService(ActionEvent event) {
        if (event.getSource() == addAnotherServiceButton) {
            if (i < 3) {
                HBox addHBox = hBoxes.get(i);
                addHBox.setVisible(true);
                i++;
            }
        } else if (event.getSource() == removeServiceButton) {
            if (i <= 3 && i > 0) {
                i--;
                HBox addHBox = hBoxes.get(i);
                addHBox.setVisible(false);
            }
        }
    }

//    public void removeService(ActionEvent event) {
//        if (i <= 3 && i > 0) {
//            i--;
//            HBox addHBox = hBoxes.get(i);
//            addHBox.setVisible(false);
//        }
//    }


    public void backToMainScreen(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("MainPane.fxml"));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}



