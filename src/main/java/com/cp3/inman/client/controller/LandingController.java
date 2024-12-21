package com.cp3.inman.client.controller;

import com.cp3.inman.client.model.Product;
import com.cp3.inman.client.model.ProductDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LandingController {
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    private ObservableList<Product> productObservableList;


    @FXML
    private TableView<Product> productTableView;

    public void loadInventory() {
        //get json file or something here
        //Product products = getProducts(<url>)
        //scrollPane.setContent();
    }

    public void add(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/cp3/inman/client/view/add-item-scene.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void setProductObservableList(ObservableList<Product> productObservableList){
        this.productObservableList =  FXCollections.observableArrayList(ProductDAO.getList());
        setProductItems(productObservableList);
    }
    public void setProductItems(ObservableList<Product> productArrayList) {
        productTableView.getColumns().clear();
        productTableView.setItems(productArrayList);
        productTableView.setEditable(true);
        TableColumn<Product, String> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().getId())+""));

        TableColumn<Product, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(e -> {
            Product product = e.getRowValue();
            product.setName(e.getNewValue());
        });

        TableColumn<Product, String> quantityColumn = new TableColumn<>("quantity");
        quantityColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().getQuantity())+""));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setOnEditCommit(e -> {
            Product product = e.getRowValue();
            try{
                product.setQuantity(Integer.parseInt(e.getNewValue()));
            }catch (NumberFormatException _){
            }
        });

        TableColumn<Product, String> priceColumn = new TableColumn<>("price");
        priceColumn.setCellValueFactory(cell -> new SimpleStringProperty((cell.getValue().getPrice())+""));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceColumn.setOnEditCommit(e -> {
            Product product = e.getRowValue();
            product.setPrice(Float.parseFloat(e.getNewValue()));
            clProducts(productArrayList);
        });
        productTableView.getColumns().addAll(idColumn,nameColumn,quantityColumn, priceColumn);
        productTableView.refresh();

    }
    public void clProducts(ObservableList<Product> list){
        list.forEach(element -> System.out.println(element.getPrice()));
    }
    public void addItem(Product product){
        productObservableList.add(product);
        setProductItems(productObservableList);
    }
    public void refreshTable(){
        //check if you can check if the observablelist is not null
        ObservableList<Product> list = FXCollections.observableList(ProductDAO.getList());
        setProductObservableList(list);
        productTableView.refresh();
    }
    public void remove(){
        Product product = productTableView.getSelectionModel().getSelectedItem();
        ProductDAO.remove(product);
        refreshTable();
    }
}
