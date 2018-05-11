package com.company.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class PaneChanger {
    public  Scene mainScene;
    public  Stage window;
    Stage paneChange(ActionEvent event, String PaneFxmlFile) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(PaneFxmlFile));
        Parent root1 = (Parent) fxmlLoader.load();
        mainScene = new Scene(root1);
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
        return window;
    }
}
