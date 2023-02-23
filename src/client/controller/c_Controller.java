package client.controller;

import client.model.c_Model;
import client.view.c_View;
import server.model.s_Model;
import server.view.s_View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class c_Controller {
    c_Model cm;
    c_View cv;

    public c_Controller(c_Model cm, c_View cv) {
        this.cm = cm;
        this.cv = cv;

        cv.getSendText().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.sendHello();
            }
        });


        // stuff
        JFrame frame = new JFrame("c_View");
        frame.setContentPane(cv.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);

    }
}

