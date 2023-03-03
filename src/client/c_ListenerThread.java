package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class c_ListenerThread implements Runnable {
    private BufferedReader in;

    // ändra till c_Controller
    private c_Controller out;

    public c_ListenerThread(BufferedReader in, c_Controller out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String msg = "";
        while (true){
            try {
                msg = in.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            out.newLog(msg);
        }

    }
    public void stop(){
        try {
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}


