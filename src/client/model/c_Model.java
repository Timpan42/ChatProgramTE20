package client.model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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

    private void getStreams() {

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
