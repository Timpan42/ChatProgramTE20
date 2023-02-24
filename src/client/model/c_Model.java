package client.model;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class c_Model {
    Socket socket;

    public int port;
    public String ip;

    PrintWriter out;
    BufferedReader in;

    public c_Model (){
        try{
            port = Integer.parseInt(JOptionPane.showInputDialog("Client: what port do you want to connect to?"));
            ip = (JOptionPane.showInputDialog("Client: what ip4 do you want to connect to?"));
            socket = new Socket(String.valueOf(ip),port);
        }catch (IOException e){
            System.err.println("Client: servern ville inte ha mig :[");
            e.printStackTrace();
        }
        System.out.println("Client: konect and ready . . .");
    }

    public void sendHello(){
        JOptionPane.showMessageDialog(null, "hello this is the client");
    }

    public void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("den stremar . . .");
    }

    public void runProtocol(){
        Scanner tgb = new Scanner(System.in);
        System.out.println("du får chatta client");
        String msg = "";
        while (!msg.equals("STOP")) {
            msg = tgb.nextLine();
            out.println("SERVER: " + msg);
        }
    }

    public static void main(String[] args) {
      /*  int port = 3;
        String ip = "10.80.46.146";
        c_Model test = new c_Model(ip, port);
        test.shutdown();
       */
    }

    private void shutdown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
