package server;

import javax.swing.*;

public class s_View {
    private JTextArea textChat;
    private JPanel viewPanel;
    private JTextField textInput;
    private JButton sendText;


    public s_View() {

    }

    public JPanel getViewPanel(){
        return viewPanel;
    }

    public JTextArea getTextChat() {
        return textChat;
    }

    public void setTextChat(String textChat) {
        this.textChat.append(textChat);
    }

    public String getTextInput() {
        return textInput.getText();
    }

    public JButton getSendText(){
        return sendText;
    }

}
