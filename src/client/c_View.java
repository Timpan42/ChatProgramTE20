package client;

import javax.swing.*;

public class c_View {
    private JTextField textEnter;
    private JButton sendText;
    private JTextArea textChat;
    private JPanel viewPanel;


    public c_View() {

    }

    public JPanel getViewPanel(){
        return viewPanel;
    }

    public JTextArea getTextChat() {
        return textChat;
    }

    public JTextField getTextEnter() {
        return textEnter;
    }

    public JButton getSendText(){
        return sendText;
    }

}

