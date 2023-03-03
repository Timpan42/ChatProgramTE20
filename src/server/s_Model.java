package server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class s_Model {
    ServerSocket server;
    Socket client;
    public int port;

    s_Controller sc;

    PrintWriter out;
    BufferedReader in;


    public String name = "";
    public String msg = "";
    public String log = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void sendLog(String msg){
        out.println(msg + "\n");
    }




    //startar servern
    public s_Model (){
        try {
            int port = Integer.parseInt(JOptionPane.showInputDialog("Server: what port do you want?"));
            System.out.println(port);
            server = new ServerSocket(port);
        } catch (IOException e){
            System.err.println("Server: nämen det funkar inte, gör bättre nästa gång");
            e.printStackTrace();
        }
        System.out.println("Server: Makaroner med server, gott");
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
            out.println("Server: " + msg);
        }
    }

    public void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

