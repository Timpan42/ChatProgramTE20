package server.model;

import com.sun.corba.se.spi.activation.Server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class s_Model {
    ServerSocket server;
    Socket client;

    PrintWriter out;
    BufferedReader in;

    //startar servern
    public s_Model (int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e){
            System.err.println("nämen det funkar inte, gör bättre nästa gång");
            e.printStackTrace();
        }
        System.out.println("Makaroner med server, gott");
    }

    public void sendHello(){
        JOptionPane.showMessageDialog(null, "hello this is the server");
    }

    /*
    //ta i mot clients
    private void acceptClients(){
        try {
            client = server.accept();
        } catch (IOException e){
            System.err.println("Funkar inte att koppla till client");
            e.printStackTrace();
        }
        System.out.println("client är här . . .");
    }

    private void getStreams(){
        try {
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("den stremar . . .");
    }
    private void runProtocol(){
        Scanner tgb = new Scanner(System.in);
        System.out.println("chattar");
        String msg = "";
        while (!msg.equals("STOP")) {
            msg = tgb.nextLine();
            out.println("SERVER: " + msg);
        }
    }
*/


    public static void main(String[] args) {
        int port = 3;
        s_Model s = new s_Model(port);
        //s.acceptClients();

        //s.runProtocol();
        s.shutdown();
    }

    private void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

