package client;

import server.s_Controller;
import server.s_ListenerThread;
import server.s_Model;
import server.s_View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_Controller {
    c_ListenerThread cl;
    Thread listener;
    c_Model cm;
    c_View cv;
    c_Controller cc;

    public void sendText() {

    }

    public void newLog(String msg) {
        cm.setLog(msg);
        cv.setTextChat(cm.getLog());
    }

    public void startThread(){
        cl = new c_ListenerThread(cm.in, cc);
        listener = new Thread(cl);
        System.out.println("thread är i gång");
    }

    public c_Controller(c_Model cm, c_View cv) {
        this.cm = cm;
        this.cv = cv;

        cv.getSendText().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cm.setMsg(cv.getTextEnter());
                String n = cm.getName();

                cm.setLog(n + ": " + cm.getMsg() + "\n");
                cv.setTextChat(cm.getLog());
                cm.sendLog(n + ": " + cm.getMsg());
                cv.setTextEnter("");
            }
        });

        // funktioner
       // sendText();
       // cm.setName("mark");
        // stuff
        JFrame frame = new JFrame("c_View");
        frame.setContentPane(cv.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);

        // starta program
      /*  cm.getStreams();
        startThread();
        listener.start();
        cm.runProtocol();
        listener.stop();
        cm.shutdown();
        cm.runProtocol();
       */

    }

    public static void main(String[] args) {
        c_Model m = new c_Model();
        c_View v = new c_View();
        c_Controller c = new c_Controller(m,v);
        m.setName("mark");

        //ServerModel s = new ServerModel(5858);
        m.getStreams();
        c_ListenerThread l = new c_ListenerThread(m.in, c);
        Thread listener = new Thread(l);
        listener.start();
        m.runProtocol();
        listener.stop();
        m.shutdown();
    }
}

