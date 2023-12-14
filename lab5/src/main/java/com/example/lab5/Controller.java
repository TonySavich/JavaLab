package com.example.lab5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bexit;



    @FXML
    private Button bstart;



    @FXML
    void initialize() {
        assert bexit != null : "fx:id=\"bexit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert bstart != null : "fx:id=\"bstart\" was not injected: check your FXML file 'hello-view.fxml'.";
bstart.setOnAction(actionEvent -> {

Game s = new Game(new Stage());
    Stage stage = (Stage) bstart.getScene().getWindow();
    stage.close();
});

        bexit.setOnAction(actionEvent -> {
            Stage stage = (Stage) bexit.getScene().getWindow();
            stage.close();
        });
    }

}