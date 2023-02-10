package client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class c_Model {
    Socket socket;

    PrintWriter out;
    BufferedReader in;

    public c_Model (String ip, int port){
        try{
            socket = new Socket(ip,port);
        }catch (IOException e){
            System.err.println("servern ville inte ha mig :[");
            e.printStackTrace();
        }
        System.out.println("conected and ready . . .");
    }

    private void getStreams() {

    }

    public static void main(String[] args) {
        int port = 3;
        String ip = "10.80.46.146";
        c_Model test = new c_Model(ip, port);
        test.shutdown();
    }

    private void shutdown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
