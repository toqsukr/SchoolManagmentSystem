package application.graphic;

import application.graphic.ui.EntityFrame;


public class StudentGUI extends EntityFrame<AddGUI> {
    public StudentGUI() {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс"}, AddGUI.class);
    }
}
