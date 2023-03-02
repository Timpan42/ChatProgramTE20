package server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class s_Controller {
    private s_Model sm;
    private s_View sv;




    public s_Controller(s_Model sm, s_View sv) {
        this.sm = sm;
        this.sv = sv;

        // send button funkar
        sv.getSendText().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String getValue = sv.getTextInput();
                sv.setTextChat(getValue + "\n");
            }
        });




        // panelen
        JFrame frame = new JFrame("s_View");
        frame.setContentPane(sv.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);

        // clienten
        sm.acceptClients();
        sm.getStreams();

        /*
        s_ListenerThread S = new s_ListenerThread(.in, sv.out);
        Thread liten = new Thread(S);
        liten.start();
         */

        sm.runProtocol();

    }
}
