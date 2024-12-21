package com.cp3.inman.client.controller;

import com.cp3.inman.client.model.Product;
import com.cp3.inman.client.model.ProductDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class LoginController {

    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label loginLabel;
    @FXML
    private PasswordField passwordField;

    public void validatePassword(ActionEvent e) throws IOException {
        String password = passwordField.getText();
        if (password.isEmpty()) {
            loginLabel.setText("Please Input Details");
        } else {
            loginLabel.setText("Logging in...");
//            System.out.println("isCorrect: " + validateInput(password));
            boolean isCorrect = validateInput(password);
            if (isCorrect) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cp3/inman/client/view/landing-scene.fxml"));
                root = loader.load();

                //gets arraylist of products from xml or json
                ObservableList<Product> productArrayList = FXCollections.observableArrayList(ProductDAO.getList());

                LandingController landingController = loader.getController();
                landingController.setProductObservableList(productArrayList);

                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    private boolean validateInput(String password) {
        //assume password is 123;
        return "123".compareTo(password) == 0;
    }

    public void hi() {
        System.out.println("Hi!");
    }


}
