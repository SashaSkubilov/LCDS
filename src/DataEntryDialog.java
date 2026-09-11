import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;

/** Modal form for entering task counts. Previous model values are used as defaults. */
public class DataEntryDialog extends JDialog {
    private final JTextField plannedField = new JTextField(12);
    private final JTextField completedField = new JTextField(12);
    private boolean confirmed;
    private int plannedTasks;
    private int completedTasks;

    public DataEntryDialog(Window owner, CalculationResult previous) {
        super(owner, "Данные за день", ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (previous != null) {
            plannedField.setText(String.valueOf(previous.plannedTasks()));
            completedField.setText(String.valueOf(previous.completedTasks()));
        }

        JPanel fields = new JPanel(new GridLayout(2, 2, 8, 8));
        fields.add(new JLabel("Запланировано дел:"));
        fields.add(plannedField);
        fields.add(new JLabel("Выполнено дел:"));
        fields.add(completedField);
        fields.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 18, 10, 18));
        add(fields, BorderLayout.CENTER);

        JButton saveButton = new JButton("Рассчитать");
        saveButton.addActionListener(event -> confirm());
        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(event -> dispose());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(saveButton);
        buttons.add(cancelButton);
        add(buttons, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(saveButton);
        pack();
        setLocationRelativeTo(owner);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public int getPlannedTasks() {
        return plannedTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    private void confirm() {
        try {
            plannedTasks = parseNonFractionalNumber(plannedField.getText(), "запланированных");
            completedTasks = parseNonFractionalNumber(completedField.getText(), "выполненных");
            confirmed = true;
            dispose();
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Некорректные данные", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int parseNonFractionalNumber(String text, String fieldName) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Введите целое число для " + fieldName + " дел.");
        }
    }
}