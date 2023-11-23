package application.graphic;

import java.util.List;

import application.entities.Student;
import application.graphic.ui.AddButton;
import application.graphic.ui.EntityFrame;
import application.graphic.ui.InfoButton;
import application.graphic.ui.MyFrame;
import application.graphic.ui.MyTable;


public class StudentGUI extends EntityFrame<Student> {

    private InfoButton<Student, InfoStudentGUI> infoBtn;

    private AddButton addBtn;

    private final AddStudentGUI addWindow = new AddStudentGUI(this);

    public StudentGUI(MyFrame parent) {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс", "Успеваемость"}, Student.class, parent);

        addBtn = new AddButton(addWindow);
        infoBtn = new InfoButton<>(this, Student.class, InfoStudentGUI.class);

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
