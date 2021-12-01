package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void openSocket(String ip, int port) throws IOException{
        clientSocket = new Socket(ip, port);
    }

    public void closeSocket() throws IOException{
        clientSocket.close();
    }

    public void startConnection() throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }


}

