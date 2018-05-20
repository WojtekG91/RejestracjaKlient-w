package com.company.Controlers;

import com.company.SQL.SQLStatements;
import com.company.Users.Client;
import javafx.collections.ObservableList;
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

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPaneControler implements Initializable {
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox serviceChoiceBox1;
    @FXML
    private Button scheduleVisitButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Label userNameLable;
    @FXML
    private javafx.scene.control.ListView upcomingVisitsList;

    public void serviceChoiceScreenOn(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ScheduleServicePane.fxml"));
        Parent root1 = (Parent) loader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
        ServiceChoiceControler serviceChoiceControler = loader.getController();
        serviceChoiceControler.getClient(client);
    }

    public void logoutButtonAction(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("LoginPane.fxml")));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SQLStatements sqlStatements = new SQLStatements();
        ArrayList<String> services = sqlStatements.getUpcomingVisits(1);
        for (String name : services) {
            upcomingVisitsList.getItems().add(name);
        }
    }
    private Client client;

    public void getClient(Client client) {
        this.client = client;
        userNameLable.setText("Witaj " + client.getName() + " " + client.getSurname());
    }

}