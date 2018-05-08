package com.company.Controlers;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.Services.ServiceRepository;
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
    public void initialize(URL url, ResourceBundle rb) {
        assert serviceChoiceBox1 != null : "fx:id=\"serviceChoiceBox1\" was not injected: check your FXML file 'ScheduleServicePane.fxml'.";

        categoryComboBox.getItems().setAll("Manicure","Pedicure", "Lashes");
        categoryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (categoryComboBox.getValue().equals("Manicure")) {
                    serviceComboBox.getItems().clear();
                    serviceComboBox.getItems().setAll("Malowanie", "Hybryda", "Klasyczny");
                } else if (categoryComboBox.getValue().equals("Pedicure")) {
                    serviceComboBox.getItems().clear();
                    serviceComboBox.getItems().setAll("Czyszczenie", "Malowanie", "Pielegnacja");
                } else if (categoryComboBox.getValue().equals("Lashes")) {
                    serviceComboBox.getItems().clear();
                    serviceComboBox.getItems().setAll("Regulacja", "Henna");
                }
            }
        });
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



