package com.company.Controlers;

import com.company.SQL.SQLStatements;
import com.company.Users.ClientRegistration;
import com.company.Users.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPaneControler implements Initializable {
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label messageField;


    public void login(ActionEvent event) throws Exception {
        Login login = new Login();
        if (login.LoginAtempt(mailTextField.getText(), passwordTextField.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPane.fxml"));
            Parent root1 = /*(Parent)*/ fxmlLoader.load();
            Scene mainScene = new Scene(root1);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(mainScene);
            window.show();
            messageField.setVisible(true);
            messageField.setText("Udane");
            SQLStatements sqlStatements = new SQLStatements();
            sqlStatements.getClient(mailTextField.getText());
        } else {
            messageField.setVisible(true);
            messageField.setText("Logowanie nieudane");
        }
    }

    public void registerScreenOn(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("RegistrationPane.fxml"));
        Parent root1 = /*(Parent)*/ fxmlLoader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

