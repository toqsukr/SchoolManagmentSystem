package application.graphic;

import application.graphic.ui.EntityFrame;


public class TeacherGUI extends EntityFrame {
    public TeacherGUI() {
        super("Список учителей", "Фамилия учителя", new String[] {"ID", "Имя", "Фамилия"});
    }
}