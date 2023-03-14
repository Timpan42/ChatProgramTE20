package server;

import com.sun.corba.se.spi.activation.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class s_Controller {
    public s_ListenerThread sl;
    private s_Model sm;
    private s_View sv;
    Thread listener;
    private s_Controller sc;


    // send text funktion
    public void sendText() {

    }

    public void newLog(String msg) {
        sm.setLog(msg);
        sv.setTextChat(sm.getLog());
    }

    public void startThread(){
        System.out.println("thread är i gång");
    }

    public s_Controller(s_Model sm, s_View sv) {
        this.sm = sm;
        this.sv = sv;
        sm.setName(JOptionPane.showInputDialog("Vad är ditt namn?"));


        sv.getSendText().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sm.setMsg(sv.getTextInput());
                String n = sm.getName();

                sm.setLog(n + ": " + sm.getMsg() + "\n");
                sv.setTextChat(sm.getLog());
                sm.sendLog(n + ": " + sm.getMsg());
                sv.setTextInput("");
            }
        });

        // panelen
        JFrame frame = new JFrame("s_View");
        frame.setContentPane(sv.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);


        // funktioner
        //sendText();
       // sm.setName("olof");

        /*
        sl = new s_ListenerThread(sm.in, sc);
        listener = new Thread(sl);
        // starta program
        sm.acceptClients();
        sm.getStreams();
        startThread();
        listener.start();
        sm.runProtocol();
        listener.stop();
        sm.shutdown();
         */
    }
    public static void main(String[] args) {
        s_Model m = new s_Model();
        s_View v = new s_View();
        s_Controller c = new s_Controller(m,v);

        //ServerModel s = new ServerModel(5858);
        m.acceptClients();
        m.getStreams();
        s_ListenerThread l = new s_ListenerThread(m.in, c);
        Thread listener = new Thread(l);
        listener.start();
        m.runProtocol();
        listener.stop();
        m.shutdown();

    }
}


