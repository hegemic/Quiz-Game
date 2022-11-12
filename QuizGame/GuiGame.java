import java.io.FileNotFoundException;

// GUI version
public class GuiGame {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        Model model = new Model();
                        Controller controller = new Controller(model);
                        View view = new View(model, controller);
                        controller.setView(view);
                        model.addObserver(view);

                    }
                });
    }
}
