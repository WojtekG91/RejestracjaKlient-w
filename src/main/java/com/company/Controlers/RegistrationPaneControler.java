package com.company.Controlers;

import com.company.Users.ClientRegistration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationPaneControler {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField mailRegistrationTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private PasswordField passwordRegistrationTextField;
    @FXML
    private PasswordField passwordVerificationTextField;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Label messageLable;

    public void register(ActionEvent event) throws Exception {
        ClientRegistration userRegistration = new ClientRegistration();
        String message = userRegistration.userRegistration(nameTextField.getText(), surnameTextField.getText(),
                mailRegistrationTextField.getText(), phoneTextField.getText(), passwordRegistrationTextField.getText(),
                passwordVerificationTextField.getText());
        if (nameTextField.getText().equals("") || surnameTextField.getText().equals("") || mailRegistrationTextField.getText().equals("")
                || phoneTextField.getText().equals("") || passwordRegistrationTextField.getText().equals("") || passwordVerificationTextField.getText().isEmpty()) {
            messageLable.setText("Proszę uzupełnić wszystkie wymagane pola.");
        } else {
            if (message.equals("Niezgodność haseł")) {
                passwordRegistrationTextField.setText("");
                passwordVerificationTextField.setText("");
                messageLable.setText(message);
            } else {
                messageLable.setText(message);
            }
        }
    }

    public void goBackToLogin(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("LoginPane.fxml"));
        Parent root1 = /*(Parent)*/ fxmlLoader.load();
        Scene mainScene = new Scene(root1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

}