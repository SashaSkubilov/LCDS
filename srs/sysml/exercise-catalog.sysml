package FitLog_ExerciseCatalog {
    part def Screen;
    part def ListItem {
        attribute text : String;
    }
    part def Button {
        attribute label : String;
    }

    part catalogScreen : Screen {
        part title : ListItem {
            text = "Выбор упражнения";
        }
        part categoryFilter : ListItem {
            text = "Категории: [Все] [Грудь] [Спина] [Ноги]";
        }
        part exerciseList : ListItem {
            text = "Жим лежа | Разводка гантелей | Отжимания на брусьях";
        }
        part btnSelect : Button {
            label = "Выбрать";
        }
        part btnAddNew : Button {
            label = "Добавить новое";
        }
    }
}