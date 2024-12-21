package com.cp3.inman.client;

import com.cp3.inman.shared.Product;
import com.cp3.inman.shared.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 6000);
                ObjectInputStream printer = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
        ) {
            System.out.println("Test main");
//            writer.writeObject("1");
//            String response = printer.readObject();
//            String responseObject = ((Response<String>) printer.readObject()).getResponse();
//            System.out.println(responseObject);
//            products.forEach(e -> System.out.println(e.getName()));
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        } catch (Exception e) {

        }

    }

}
class Student implements Serializable {
    private int id;
    private String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
