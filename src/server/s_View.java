package server;

import javax.swing.*;

public class s_View {
    private JTextArea textChat;
    private JPanel viewPanel;
    private JTextField textField;
    private JButton sendText;


    public s_View() {

    }

    public JPanel getViewPanel(){
        return viewPanel;
    }

    public JTextArea getTextChat() {
        return textChat;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getSendText(){
        return sendText;
    }

}
