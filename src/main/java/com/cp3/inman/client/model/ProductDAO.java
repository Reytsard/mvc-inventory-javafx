package com.cp3.inman.client.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductDAO {
    private static ArrayList<Product> list = new ArrayList<>(Arrays.asList(new Product(1,"Apple",10,10.353f),new Product(2,"orange",10,52125.3352f)));
    public static ArrayList<Product> getList(){
        return list;
    }

    public static void remove(Product product) {
        list.remove(product);
    }

    ObservableList<Product> getListFromFile(String path){
        //toChange
        if(list == null) return null;
        return FXCollections.observableArrayList();
    }
    static void saveListToJSON(){
        //do things to save to json
    }
    static void saveListToXML(){
        //do things to save to xml
    }
    public static void addProduct(Product product){
        if(!list.stream().anyMatch(e -> e.getId() == product.getId())){
            list.add(product);
            System.out.println("Item Id is the same");
        }
    }

}
