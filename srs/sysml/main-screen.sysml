package FitLog_MainScreen {
    part def Screen;
    part def ListItem {
        attribute text : String;
    }
    part def Button {
        attribute label : String;
    }

    part mainScreen : Screen {
        part title : ListItem {
            text = "FitLog - Дневник тренировок";
        }
        part historyList : ListItem {
            text = "21.10 - Жим (3x10, 80кг) | 19.10 - Приседания (4x8, 100кг)";
        }
        part btnNew : Button {
            label = "+ Новая тренировка";
        }
        part btnCatalog : Button {
            label = "Справочник";
        }
        part btnCharts : Button {
            label = "Графики";
        }
        part btnReminders : Button {
            label = "Напоминания";
        }
    }
}