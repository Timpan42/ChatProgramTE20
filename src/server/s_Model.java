package server;

import com.sun.corba.se.spi.activation.Server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class s_Model {
    ServerSocket server;
    Socket client;
    public int port;

    PrintWriter out;
    BufferedReader in;

    //startar servern
    public s_Model (){
        try {
            port = Integer.parseInt(JOptionPane.showInputDialog("Server: what port do you want?"));
            System.out.println(port);
            server = new ServerSocket(port);
        } catch (IOException e){
            System.err.println("Server: nämen det funkar inte, gör bättre nästa gång");
            e.printStackTrace();
        }
        System.out.println("Server: Makaroner med server, gott");
    }

    public void sendHelp(){
        JOptionPane.showMessageDialog(null, "hello this is the server");
    }

    //ta i mot clients
    public void acceptClients(){
        try {
            client = server.accept();
        } catch (IOException e){
            System.err.println("Server: Funkar inte att koppla till client");
            e.printStackTrace();
        }
        System.out.println("Server: client är här . . .");
    }

    public void getStreams(){
        try {
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("den stremar . . .");
    }

    public void runProtocol(){
        Scanner tgb = new Scanner(System.in);
        System.out.println("Du får chatta server");
        String msg = "";
        while (!msg.equals("STOP")) {
            msg = tgb.nextLine();
            out.println("SERVER: " + msg);
        }
    }

    private void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

