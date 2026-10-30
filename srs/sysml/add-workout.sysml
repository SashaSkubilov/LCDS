package FitLog_AddWorkout {
    part def Screen;
    part def InputField {
        attribute label : String;
        attribute value : String;
    }
    part def Button {
        attribute label : String;
    }

    part addWorkoutScreen : Screen {
        part dateField : InputField {
            label = "Дата";
            value = "21.10.2026";
        }
        part exerciseField : InputField {
            label = "Упражнение";
            value = "Жим лежа (грудь)";
        }
        part setsField : InputField {
            label = "Подходы";
            value = "3";
        }
        part repsField : InputField {
            label = "Повторения";
            value = "10";
        }
        part weightField : InputField {
            label = "Вес (кг)";
            value = "80";
        }
        part saveButton : Button {
            label = "Сохранить";
        }
        part cancelButton : Button {
            label = "Отмена";
        }
    }
}