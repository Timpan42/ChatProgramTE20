package client;

import client.controller.c_Controller;
import client.model.c_Model;
import client.view.c_View;
import server.controller.s_Controller;
import server.model.s_Model;
import server.view.s_View;

public class c_main {
    public static void main(String[] args) {
        c_Model model = new c_Model();
        c_View view = new c_View();
        c_Controller controller = new c_Controller(model, view);
        // 10.80.46.146
        // ip4
        // 172.17.240.1
        // Lukas

    }
}
