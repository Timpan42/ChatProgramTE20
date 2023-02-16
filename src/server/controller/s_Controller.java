package server.controller;

import server.model.s_Model;
import server.view.s_View;

import javax.swing.*;

public class s_Controller {
    private s_Model model;
    private s_View view;

    public s_Controller(s_Model model, s_View view) {
        this.model = model;
        this.view = view;

        JFrame frame = new JFrame("s_View");
        frame.setContentPane(view.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
