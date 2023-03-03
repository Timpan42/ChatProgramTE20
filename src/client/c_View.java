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

    public void setTextChat(String textChat){
        this.textChat.append(textChat);
    }

    public void setTextEnter(String textInput) {
        this.textEnter.setText(textInput);
    }

    public String getTextEnter() {
        return textEnter.getText();
    }

    public JButton getSendText(){
        return sendText;
    }

}

