package application.graphic;

import java.util.List;

import application.entities.Student;
import application.graphic.ui.MyTable;
import application.graphic.ui.buttons.AddOpenButton;
import application.graphic.ui.buttons.InfoOpenButton;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.MyFrame;


public class StudentFrame extends EntityFrame<Student> {

    private InfoOpenButton<Student> infoBtn;

    private AddOpenButton addBtn;

    private final AddStudentFrame addWindow = new AddStudentFrame(this);

    public StudentFrame(MyFrame parent) {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс", "Успеваемость"}, Student.class, parent);

        addBtn = new AddOpenButton(addWindow);
        infoBtn = new InfoOpenButton<>(this, Student.class, InfoStudentFrame.class);

        toolBar.add(addBtn, 0);
        toolBar.add(infoBtn);
        setTable();
    }

    public void setTable() {
        if (defaultTable.getRowCount() != 0)
            MyTable.clearTable(defaultTable);
        List<Student> students = Student.getEntityDao().getAll();

        for (Student student : students) {
            defaultTable.addRow(
                    new String[] { student.getStudentID().toString(), student.getName(), student.getSurname(), student.getKlass().getName(), student.determineStudentStatus()});
        }
    }
}
