package client;

public class c_main {
    public static void main(String[] args) {
        c_Model model = new c_Model();
        c_View view = new c_View();
        c_Controller controller = new c_Controller(model, view);

    }
}
