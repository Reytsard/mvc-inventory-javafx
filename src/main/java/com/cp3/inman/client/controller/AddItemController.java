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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddItemController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label idLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField priceTextField;

    boolean isComplete = false;
    boolean idIsFilled = false;
    boolean nameIsFilled = false;
    boolean quantityIsFilled = false;
    boolean priceIsFilled = false;

    public void add(ActionEvent e) throws IOException {
        String id = idTextField.getText();
        String name = nameTextField.getText();
        String quantity = quantityTextField.getText();
        String price = priceTextField.getText();
        //validation
        if (id.trim().isEmpty()) {
            idLabel.setText("Field Required");
            idIsFilled = false;
        } else {
            ArrayList<Product> list = ProductDAO.getList();
            if (list.stream().anyMatch(product -> product.getId() == (Integer.parseInt(id)))) {
                idIsFilled = false;
                idLabel.setText("ID/Serial Number already exists.");
            } else {
                idIsFilled = true;
            }
        }
        if (name.trim().isEmpty()) {
            nameLabel.setText("Field Required");
            nameIsFilled = false;
        } else {


            nameIsFilled = true;
        }
        try {
            if (Integer.parseInt(quantity) == 0 || Integer.parseInt(quantity) < 0) {
                quantityLabel.setText("Field Required");
                quantityIsFilled = false;
            } else {
                quantityIsFilled = true;
            }
            if (Float.parseFloat(price) < 0) {
                priceLabel.setText("Price must not be lower than 0");
                priceIsFilled = false;

            } else {
                priceIsFilled = true;
            }
        } catch (NumberFormatException _) {
            //quantity input is wrong or price input is wrong
        }
        isComplete = quantityIsFilled && nameIsFilled && priceIsFilled && idIsFilled;
        if (isComplete) {
            Product product = new Product(Integer.parseInt(id), name, Integer.parseInt(quantity), Float.parseFloat(price));
            ProductDAO.addProduct(product);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cp3/inman/client/view/landing-scene.fxml"));
            root = loader.load();
            LandingController landingController = loader.getController();
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            landingController.refreshTable();
        }

    }

    public void cancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/cp3/inman/client/view/landing-scene.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        LandingController landingController = loader.getController();
        landingController.refreshTable();

    }

}
