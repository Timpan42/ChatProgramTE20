package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class s_ListenerThread implements Runnable {
    private BufferedReader in;
    private PrintStream out;

    public s_ListenerThread(BufferedReader in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String msg = null;
        while (true){
            try {
                msg = in.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            out.println(msg);
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

