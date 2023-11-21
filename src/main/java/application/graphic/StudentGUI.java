package application.graphic;

import application.graphic.ui.EntityFrame;
import application.graphic.ui.MyFrame;


public class StudentGUI extends EntityFrame<AddGUI> {
    public StudentGUI(MyFrame parent) {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс"}, AddGUI.class, parent);
    }

    public void setTable() {

    }
}
