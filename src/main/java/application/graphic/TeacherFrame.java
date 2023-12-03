package application.graphic;

import java.util.List;

import application.entities.Teacher;
import application.graphic.ui.MyTable;
import application.graphic.ui.buttons.AddOpenButton;
import application.graphic.ui.buttons.EditOpenButton;
import application.graphic.ui.buttons.InfoOpenButton;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.MyFrame;


public class TeacherFrame extends EntityFrame<Teacher> {

    private InfoOpenButton<Teacher> infoBtn;

    private EditOpenButton<Teacher> editBtn;
    
    private AddOpenButton addBtn;
    
    private final AddTeacherFrame addWindow = new AddTeacherFrame(this);
    
    public TeacherFrame(MyFrame parent) {
        super("Список учителей", new String[] {"ID", "Имя", "Фамилия"}, Teacher.class, parent);

        addBtn = new AddOpenButton(addWindow);
        infoBtn = new InfoOpenButton<>(this, Teacher.class, InfoTeacherFrame.class);
        editBtn = new EditOpenButton<>(this, Teacher.class, EditTeacherFrame.class);
        toolBar.add(addBtn, 0);
        toolBar.add(editBtn, 2);
        toolBar.add(infoBtn);
        initTable();
    }

    public void initTable() {
        if (defaultTable.getRowCount() != 0)
            MyTable.clearTable(defaultTable);
        List<Teacher> teachers = Teacher.getEntityDao().getAll();

        for (Teacher teacher : teachers) {
            defaultTable.addRow(
                    new String[] { teacher.getTeacherID().toString(), teacher.getName(), teacher.getSurname()});
        }
    }
}