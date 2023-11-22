package application.graphic;

import java.util.List;

import application.entities.Student;
import application.graphic.ui.EntityFrame;
import application.graphic.ui.MyFrame;
import application.graphic.ui.MyTable;


public class StudentGUI extends EntityFrame<Student> {
    public StudentGUI(MyFrame parent) {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс"}, AddStudentGUI.class, parent);
        setTable();
    }

    public void setTable() {
        if (defaultTable.getRowCount() != 0)
            MyTable.clearTable(defaultTable);
        List<Student> students = Student.getEntityDao().getAll();

        for (Student student : students) {
            defaultTable.addRow(
                    new String[] { student.getStudentID().toString(), student.getName(), student.getSurname(), student.getKlass().getName()});
        }
    }

    public Student getObjectToDelete() {
        return new Student();
    }
}
