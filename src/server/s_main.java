package server;

import server.model.s_Model;
import server.controller.s_Controller;
import server.view.s_View;


public class s_main {
    public static void main(String[] args) {
        s_Model model = new s_Model();
        s_View view = new s_View();
        s_Controller controller = new s_Controller(model, view);

    }
}
