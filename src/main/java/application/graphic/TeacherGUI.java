package application.graphic;

import java.util.List;

import application.entities.Teacher;
import application.graphic.ui.AddButton;
import application.graphic.ui.EntityFrame;
import application.graphic.ui.InfoButton;
import application.graphic.ui.MyFrame;
import application.graphic.ui.MyTable;


public class TeacherGUI extends EntityFrame<Teacher> {

    private InfoButton<Teacher, InfoTeacherGUI> infoBtn;
    
    private AddButton addBtn;
    
    private final AddTeacherGUI addWindow = new AddTeacherGUI(this);
    
    public TeacherGUI(MyFrame parent) {
        super("Список учителей", "Фамилия учителя", new String[] {"ID", "Имя", "Фамилия"}, Teacher.class, parent);

        addBtn = new AddButton(addWindow);
        infoBtn = new InfoButton<>(this, Teacher.class, InfoTeacherGUI.class);
        toolBar.add(addBtn, 0);
        toolBar.add(infoBtn);
        setTable();
    }

    public void setTable() {
        if (defaultTable.getRowCount() != 0)
            MyTable.clearTable(defaultTable);
        List<Teacher> teachers = Teacher.getEntityDao().getAll();

        for (Teacher teacher : teachers) {
            defaultTable.addRow(
                    new String[] { teacher.getTeacherID().toString(), teacher.getName(), teacher.getSurname()});
        }
    }
}