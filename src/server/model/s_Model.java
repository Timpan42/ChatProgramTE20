package server.model;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class s_Model {
    ServerSocket server;
    Socket client;

    public s_Model (int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e){
            System.err.println("nämen det funkar inte, gör bättre nästa gång");
            e.printStackTrace();
        }
        System.out.println("Makaroner med server, gott");
    }

    public static void main(String[] args) {
        int port = 3;
        s_Model s = new s_Model(port);
    }
}
