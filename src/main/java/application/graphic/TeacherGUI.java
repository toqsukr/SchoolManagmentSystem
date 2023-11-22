package application.graphic;

import java.util.ArrayList;
import java.util.List;

import application.entities.Teacher;
import application.graphic.ui.EntityFrame;
import application.graphic.ui.MyFrame;
import application.graphic.ui.MyTable;
import application.utils.ListHelper;


public class TeacherGUI extends EntityFrame<Teacher> {
    
    public TeacherGUI(MyFrame parent) {
        super("Список учителей", "Фамилия учителя", new String[] {"ID", "Имя", "Фамилия"}, Teacher.class, AddTeacherGUI.class, parent);
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

    public List<Teacher> getObjectsToDelete() {
        int[] selectedIndexes = table.getSelectedRows();
        List<String> stringObjects = new ArrayList<>();
        for(int index: selectedIndexes) {
            stringObjects.add(defaultTable.getValueAt(index, 0).toString());
        }
        ListHelper<Teacher> helper = new ListHelper<>();
        return helper.getSelectedList(stringObjects, Teacher.class);
    }
}