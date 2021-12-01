package com.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int port;
    static String message;
    static Client client = new Client();
    public static void main(String[] args) {

        getSettings();
        createSocket();
        startConnection();
        sendMessage();
        stopConnection();
    }

    private static void getSettings(){
        Scanner sc = new Scanner(System.in);
        Scanner scm = new Scanner(System.in);
        System.out.println("Podaj port komunikacji:");
        port = sc.nextInt();
        System.out.println("Podaj wiadomość:");
        message = scm.nextLine();
    }

    private static void createSocket(){
        try {
            client.openSocket("localhost",port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeSocket(){
        try {
            client.closeSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startConnection(){
        try {
            client.startConnection();
            System.out.println("Połączenie nawiązane!");
        } catch (IOException e) {
            e.printStackTrace();
            closeSocket();
        }
    }
    private static void stopConnection(){
        try{
            client.stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void sendMessage(){
        try{
            System.out.println("Odpowiedź serwera: "+client.sendMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
            stopConnection();
            closeSocket();
        }
    }

}
