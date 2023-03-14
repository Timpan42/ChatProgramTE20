package client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class c_Model {
    Socket socket;

    public int port;
    public String ip;

    PrintStream out;
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
        out.println(msg);
    }

    public c_Model (){
        try{
            int port = Integer.parseInt(JOptionPane.showInputDialog("Client: what port do you want to connect to?"));
            String ip = (JOptionPane.showInputDialog("Client: what ip4 do you want to connect to?"));
            socket = new Socket(String.valueOf(ip),port);
        }catch (IOException e){
            System.err.println("Client: servern ville inte ha mig :[");
            e.printStackTrace();
        }
        System.out.println("Client: konect and ready . . .");
    }


    public void getStreams() {
        try {
            out = new PrintStream(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("den stremar . . .");
    }

    public void runProtocol(){
        Scanner tgb = new Scanner(System.in);
        System.out.println("du får chatta client");
        while (!msg.equals("STOP")) {
            msg = tgb.nextLine();
            out.println("Client: " + msg);
        }
    }

    public void shutdown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
