package FitLog_Reminders {
    part def Screen;
    part def Toggle {
        attribute label : String;
        attribute state : String;
    }
    part def InputField {
        attribute label : String;
        attribute value : String;
    }
    part def Button {
        attribute label : String;
    }

    part remindersScreen : Screen {
        part title : InputField {
            label = "Экран";
            value = "Настройка напоминаний";
        }
        part enableToggle : Toggle {
            label = "Включить напоминания";
            state = "Да";
        }
        part daysInput : InputField {
            label = "Дни недели";
            value = "Пн, Ср, Пт";
        }
        part timeInput : InputField {
            label = "Время";
            value = "18:00";
        }
        part saveButton : Button {
            label = "Сохранить";
        }
        part cancelButton : Button {
            label = "Отмена";
        }
    }
}