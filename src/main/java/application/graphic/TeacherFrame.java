package application.graphic;

import java.util.List;

import application.entities.Teacher;
import application.graphic.ui.MyTable;
import application.graphic.ui.buttons.AddButton;
import application.graphic.ui.buttons.InfoButton;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.MyFrame;


public class TeacherFrame extends EntityFrame<Teacher> {

    private InfoButton<Teacher, InfoTeacherFrame> infoBtn;
    
    private AddButton addBtn;
    
    private final AddTeacherFrame addWindow = new AddTeacherFrame(this);
    
    public TeacherFrame(MyFrame parent) {
        super("Список учителей", "Фамилия учителя", new String[] {"ID", "Имя", "Фамилия"}, Teacher.class, parent);

        addBtn = new AddButton(addWindow);
        infoBtn = new InfoButton<>(this, Teacher.class, InfoTeacherFrame.class);
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