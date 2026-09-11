//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
setSystemLookAndFeel();

LazyCalculatorModel model = new LazyCalculatorModel();
MainView view = new MainView();
            new LazyCalculatorController(model, view);
            view.setVisible(true);
        });
                }
private static void setSystemLookAndFeel() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ignored) {
    }
}
}

