import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.Locale;

/** Main view. It contains no calculation logic and only renders the model state. */
public class MainView extends JFrame {
    private final JButton enterDataButton = new JButton("Ввести данные");
    private final JLabel plannedValue = valueLabel("—");
    private final JLabel completedValue = valueLabel("—");
    private final JLabel coefficientValue = valueLabel("—");
    private final JLabel levelValue = valueLabel("—");
    private final JLabel phraseValue = new JLabel("Введите данные, чтобы узнать результат.", SwingConstants.CENTER);

    public MainView() {
        super("Калькулятор лени");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(540, 360));
        setLocationByPlatform(true);

        JLabel title = new JLabel("Калькулятор лени", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 12, 20));
        add(title, BorderLayout.NORTH);

        JPanel values = new JPanel(new GridLayout(4, 2, 10, 10));
        values.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        addRow(values, "Запланировано дел:", plannedValue);
        addRow(values, "Выполнено дел:", completedValue);
        addRow(values, "Коэффициент лени:", coefficientValue);
        addRow(values, "Уровень прокрастинации:", levelValue);

        JPanel center = new JPanel(new BorderLayout(8, 8));
        center.add(values, BorderLayout.NORTH);
        phraseValue.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Вердикт"), BorderFactory.createEmptyBorder(12, 12, 12, 12)));
        center.add(phraseValue, BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);

        JPanel actions = new JPanel();
        actions.setBorder(BorderFactory.createEmptyBorder(8, 8, 20, 8));
        actions.add(enterDataButton);
        add(actions, BorderLayout.SOUTH);
        pack();
    }

    public void setEnterDataAction(java.awt.event.ActionListener listener) {
        enterDataButton.addActionListener(listener);
    }

    public void showResult(CalculationResult result) {
        plannedValue.setText(String.valueOf(result.plannedTasks()));
        completedValue.setText(String.valueOf(result.completedTasks()));
        coefficientValue.setText(String.format(Locale.forLanguageTag("ru-RU"), "%.1f%%", result.lazinessCoefficient()));
        levelValue.setText(result.procrastinationLevel());
        phraseValue.setText("<html><div style='text-align:center;'>" + result.phrase() + "</div></html>");
    }

    public Window dialogOwner() {
        return this;
    }

    private static JLabel valueLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.RIGHT);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        return label;
    }

    private static void addRow(JPanel panel, String name, JLabel value) {
        panel.add(new JLabel(name));
        panel.add(value);
    }
}