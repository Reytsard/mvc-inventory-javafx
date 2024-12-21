package com.cp3.inman.server.controller;

import com.cp3.inman.shared.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerController implements Runnable {
    ObjectOutputStream writer;
    ObjectInputStream printer;
    Socket socket;

    public ServerController(Socket socket, ObjectInputStream printer, ObjectOutputStream writer) {
        this.socket = socket;
        this.writer = writer;
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            int reqChoice =  printer.readInt();
            switch (reqChoice) {
                case 1 -> {
//                    ArrayList<Product> list = new ArrayList<>(Arrays.asList(new Product(1, "Orange", 10, 24.2f), new Product(2, "Apple", 241, 2.24f)));
                    writer.writeChars("Hi");
                }
                case 2 -> {
                    ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product(1,"apple",10,20.2f),new Product(2,"orange",2,10.2f)));
                    writer.writeObject(products);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
