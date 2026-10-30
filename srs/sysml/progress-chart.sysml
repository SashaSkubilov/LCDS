package FitLog_ProgressChart {
    part def Screen;
    part def Dropdown {
        attribute label : String;
        attribute value : String;
    }
    part def Chart {
        attribute title : String;
        attribute trend : String;
    }

    part chartScreen : Screen {
        part title : Dropdown {
            label = "Экран";
            value = "Прогресс - Жим лежа";
        }
        part exerciseFilter : Dropdown {
            label = "Упражнение";
            value = "Жим лежа";
        }
        part periodFilter : Dropdown {
            label = "Период";
            value = "За 3 месяца";
        }
        part weightChart : Chart {
            title = "График веса";
            trend = "80кг -> 85кг -> 90кг (Рост)";
        }
    }
}