package com.company.Controlers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ServiceChoiceControler implements Initializable {

    private Button removeServiceButton;
    @FXML
    private Button addAnotherServiceButton;
    @FXML
    private TableView<Service> manicureTableView;
    @FXML
    private TableColumn<Service, String> manicureServiceName;
    @FXML
    private TableColumn<Service, Double> manicureServicePrice;
    @FXML
    private TableColumn<Service, Integer> manicureServiceDuration;
    @FXML
    private TableView<Service> pedicureTableView;
    @FXML
    private TableColumn<Service, String> pedicureServiceName;
    @FXML
    private TableColumn<Service, Double> pedicureServicePrice;
    @FXML
    private TableColumn<Service, Integer> pedicureServiceDuration;
    @FXML
    private Tab pedicureTabButton;
    @FXML
    private TabPane tabPane;
    @FXML
    private ListView addedServiceList;
    @FXML
    private Label extimatedTimeLable;
    @FXML
    private Label sumToPayLable;

    private Map<String, String> prices = new HashMap<>();
    private Map<String, String> duration = new HashMap<>();
    ArrayList<HBox> hBoxes = new ArrayList<>();
    ServiceRepository serviceRepository = new ServiceRepository();

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //assert serviceChoiceBox1 != null : "fx:id=\"serviceChoiceBox1\" was not injected: check your FXML file 'ScheduleServicePane.fxml'.";
//        addedServiceList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        manicureServiceName.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        manicureServicePrice.setCellValueFactory(new PropertyValueFactory<Service, Double>("price"));
        manicureServiceDuration.setCellValueFactory(new PropertyValueFactory<Service, Integer>("duration"));

        pedicureServiceName.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
        pedicureServicePrice.setCellValueFactory(new PropertyValueFactory<Service, Double>("price"));
        pedicureServiceDuration.setCellValueFactory(new PropertyValueFactory<Service, Integer>("duration"));

           manicureTableView.setItems(manicureList());
        pedicureTableView.setItems(pedicureList());

    }

    Integer totalTime = 0;
    Double totalPrice = 0.0;

    @FXML
    private void getService(ActionEvent event) {
        Service service = manicureTableView.getSelectionModel().getSelectedItem();
        Service service2 = pedicureTableView.getSelectionModel().getSelectedItem();
        if (event.getSource() == addAnotherServiceButton) {
            if (service == null && service2 == null) {
                System.out.println("Nothing selected");
            } else if (service != null){
//                String name = service.getName();
                Double price = service.getPrice();
                Integer duration = service.getDuration();
                addedServiceList.getItems().add(service);
                totalTime += duration;
                extimatedTimeLable.setText(totalTime.toString() + " min");
                totalPrice += price;
                sumToPayLable.setText(totalPrice.toString() + " PLN");
            } else if (service2 != null){
                Double price = service2.getPrice();
                Integer duration = service2.getDuration();
                addedServiceList.getItems().add(service2);
                totalTime += duration;
                extimatedTimeLable.setText(totalTime.toString() + " min");
                totalPrice += price;
                sumToPayLable.setText(totalPrice.toString() + " PLN");
            }

        } else if (event.getSource() == removeServiceButton) {
            ObservableList<Service> selected;
            selected = addedServiceList.getSelectionModel().getSelectedItems();

        }
    }


    private ObservableList<Service> manicureList() {
        ObservableList<Service> serviceManicure = FXCollections.observableArrayList(serviceRepository.manicure());
        return serviceManicure;
    }

    private ObservableList<Service> pedicureList() {
        ObservableList<Service> servicePedicure = FXCollections.observableArrayList(serviceRepository.pedicure());
        return servicePedicure;
    }

//    public void fillTab(ActionEvent event) {
//        pedicureServiceName.setCellValueFactory(new PropertyValueFactory<Service, String>("name"));
//        pedicureServicePrice.setCellValueFactory(new PropertyValueFactory<Service, Double>("price"));
//        pedicureServiceDuration.setCellValueFactory(new PropertyValueFactory<Service, Integer>("name"));
//        pedicureTableView.setItems(pedicureList());
//    }


    public void backToMainScreen(ActionEvent event) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("MainPane.fxml"));
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}



