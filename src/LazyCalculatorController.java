import javax.swing.JOptionPane;

/** Connects the active model and the views. */
public class LazyCalculatorController {
    private final LazyCalculatorModel model;
    private final MainView view;

    public LazyCalculatorController(LazyCalculatorModel model, MainView view) {
        this.model = model;
        this.view = view;
        model.addPropertyChangeListener(event -> view.showResult((CalculationResult) event.getNewValue()));
        view.setEnterDataAction(event -> openEntryDialog());
    }

    private void openEntryDialog() {
        CalculationResult previous = model.getResult();
        DataEntryDialog dialog = new DataEntryDialog(view.dialogOwner(), previous);
        dialog.setVisible(true);
        if (!dialog.isConfirmed()) {
            return;
        }

        try {
            model.calculate(dialog.getPlannedTasks(), dialog.getCompletedTasks());
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(view, exception.getMessage(), "Некорректные данные", JOptionPane.ERROR_MESSAGE);
        }
    }
}
