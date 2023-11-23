package application.graphic;

import java.util.ArrayList;
import java.util.List;

import application.entities.Student;
import application.graphic.ui.AddButton;
import application.graphic.ui.EntityFrame;
import application.graphic.ui.InfoButton;
import application.graphic.ui.MyFrame;
import application.graphic.ui.MyTable;
import application.utils.ListHelper;


public class StudentGUI extends EntityFrame<Student> {

    private InfoButton infoBtn;

    private AddButton addBtn;

    private final AddStudentGUI addWindow = new AddStudentGUI(this);

    public StudentGUI(MyFrame parent) {
        super("Список студентов", "Фамилия студента", new String[] {"ID", "Имя", "Фамилия", "Класс", "Успеваемость"}, Student.class, parent);

        addBtn = new AddButton(addWindow);
        infoBtn = new InfoButton(this);

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

    public List<Student> getObjectsToDelete() {
        int[] selectedIndexes = table.getSelectedRows();
        List<String> stringObjects = new ArrayList<>();
        for(int index: selectedIndexes) {
            stringObjects.add(defaultTable.getValueAt(index, 0).toString());
        }
        ListHelper<Student> helper = new ListHelper<>();
        return helper.getSelectedList(stringObjects, Student.class);
    }
}
