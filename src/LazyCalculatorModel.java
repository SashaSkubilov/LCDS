import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Active MVC model: it stores the last values, calculates the result and notifies its listeners.
 */
public class LazyCalculatorModel {
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private CalculationResult result;

    public void calculate(int plannedTasks, int completedTasks) {
        validate(plannedTasks, completedTasks);

        CalculationResult oldResult = result;
        double lazinessCoefficient = (plannedTasks - completedTasks) * 100.0 / plannedTasks;
        result = new CalculationResult(plannedTasks, completedTasks, lazinessCoefficient,
                procrastinationLevel(lazinessCoefficient), phraseFor(lazinessCoefficient));
        changes.firePropertyChange("result", oldResult, result);
    }

    public CalculationResult getResult() {
        return result;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    private void validate(int plannedTasks, int completedTasks) {
        if (plannedTasks <= 0) {
            throw new IllegalArgumentException("Количество запланированных дел должно быть больше нуля.");
        }
        if (completedTasks < 0) {
            throw new IllegalArgumentException("Количество выполненных дел не может быть отрицательным.");
        }
        if (completedTasks > plannedTasks) {
            throw new IllegalArgumentException("Выполненных дел не может быть больше, чем запланированных.");
        }
    }

    private String procrastinationLevel(double coefficient) {
        if (coefficient == 0) {
            return "Отсутствует";
        }
        if (coefficient <= 25) {
            return "Низкий";
        }
        if (coefficient <= 50) {
            return "Средний";
        }
        if (coefficient <= 75) {
            return "Высокий";
        }
        return "Критический";
    }

    private String phraseFor(double coefficient) {
        if (coefficient == 0) {
            return "Идеально! Сегодня прокрастинация не прошла.";
        }
        if (coefficient <= 25) {
            return "Отличный темп — небольшой отдых вполне заслужен.";
        }
        if (coefficient <= 50) {
            return "Половина пути пройдена. Завтра попробуйте сделать ещё один шаг.";
        }
        if (coefficient <= 75) {
            return "Список дел ждёт вас. Возможно, пора начать с самого маленького пункта?";
        }
        return "План был смелым. Диван, похоже, оказался ещё смелее.";
    }
}
