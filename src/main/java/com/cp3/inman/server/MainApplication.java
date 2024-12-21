package com.cp3.inman.server;

import com.cp3.inman.server.controller.ServerController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication {
    public static void main(String[] args) {
        MainApplication program;
        try {
            program = new MainApplication();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        System.out.println("Server has Started");
        int PORT = 6000;
        while (true) {
            try (
                    ExecutorService es = Executors.newFixedThreadPool(10);
                    ServerSocket serverSocket = new ServerSocket(PORT);
                    Socket socket = serverSocket.accept();
                    ObjectInputStream printer = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            ) {
                System.out.println("A connection has been established");
                es.execute(new ServerController(socket, printer, writer));
            }

        }
    }
}
