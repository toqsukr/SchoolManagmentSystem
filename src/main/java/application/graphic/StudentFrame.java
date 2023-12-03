package application.graphic;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import application.entities.Klass;
import application.entities.Student;
import application.graphic.ui.MyTable;
import application.graphic.ui.buttons.AddOpenButton;
import application.graphic.ui.buttons.EditOpenButton;
import application.graphic.ui.buttons.InfoOpenButton;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.MyFrame;


public class StudentFrame extends EntityFrame<Student> {

    private InfoOpenButton<Student> infoBtn;

    private EditOpenButton<Student> editBtn;

    private AddOpenButton addBtn;

    private final AddStudentFrame addWindow = new AddStudentFrame(this);

    /**
     * This button performs a search
     */
    private JButton searchBtn = new JButton("Искать");

    /**
     * This button performs a disrupt values of search inputs
     */
    private JButton disruptInputBtn = new JButton("Сбросить фильтр");

    private JTextField searchNameField;

    private JLabel fieldNumber = new JLabel();

    private JComboBox<String> comboSearchKlass = new JComboBox<>();
    private JComboBox<String> comboSearchStatus = new JComboBox<>();


    public StudentFrame(MyFrame parent) {

        super("Список студентов", new String[] {"ID", "Имя", "Фамилия", "Класс", "Успеваемость"}, Student.class, parent);

        searchBtn.setBackground(new Color(0xDFD9D9D9, false));
        disruptInputBtn.setBackground(new Color(0xDFD9D9D9, false));

        searchNameField = new JTextField("Фамилия студента", 12);
        searchNameField.addFocusListener(new InputFocusListener());
        searchNameField.setMargin(new Insets(2, 2, 3, 0));
    
        searchBtn.setMargin(new Insets(1, 6, 1, 6));
        disruptInputBtn.setMargin(new Insets(1, 6, 1, 20));    

        disruptInputBtn.addActionListener(new DisruptEventListener());
        searchBtn.addActionListener(new SearchEventListener());
    
        filterPanel.add(searchNameField);
        filterPanel.add(comboSearchKlass);
        filterPanel.add(comboSearchStatus);
        filterPanel.add(searchBtn);
        filterPanel.add(disruptInputBtn);
        filterPanel.add(fieldNumber);

        setComboKlass();
        setComboStatus();

        addBtn = new AddOpenButton(addWindow);
        infoBtn = new InfoOpenButton<>(this, Student.class, InfoStudentFrame.class);
        editBtn = new EditOpenButton<>(this, Student.class, EditStudentFrame.class);

        toolBar.add(addBtn, 0);
        toolBar.add(editBtn, 2);
        toolBar.add(infoBtn);
        initTable();
    }

    public void setComboKlass() {
        clearCombo(comboSearchKlass);
        List<Klass> klasses = Klass.getEntityDao().getAll();
        for(Klass klass: klasses) {
            comboSearchKlass.addItem(klass.getName());
        }
    }

    private void setComboStatus() {
        clearCombo(comboSearchStatus);
        comboSearchStatus.addItem("Двоечник");
        comboSearchStatus.addItem("Троечник");
        comboSearchStatus.addItem("Хорошист");
        comboSearchStatus.addItem("Отличник");
    }

    private void clearCombo(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Все");
    }

    public void initTable() {
        List<Student> students = Student.getEntityDao().getAll();
        setTable(students);
    }

    public void setTable(List<Student> students) {
        if (defaultTable.getRowCount() != 0)
            MyTable.clearTable(defaultTable);
        for (Student student : students) {
            defaultTable.addRow(
                    new String[] { student.getStudentID().toString(), student.getName(), student.getSurname(), student.getKlass().getName(), student.determineStudentStatus()});
        }
        fieldNumber.setText("Количество строк: " + students.size());
    }

    public static void setInput(JTextField input, String text) {
        input.setText(text);
    }

    public class InputFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            if (searchNameField.getText().equals("Фамилия студента"))
                setInput(searchNameField, "");
        }

        public void focusLost(FocusEvent e) {
            if (searchNameField.getText().equals(""))
                setInput(searchNameField, "Фамилия студента");
        }
    }

    public class SearchEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String query = "from Student s where s.surname LIKE :surname AND s.klass.name LIKE :klass";
            Map<String, Object> params = new HashMap<>();
            if(!searchNameField.getText().equals("Фамилия студента")) {
                params.put("surname", "%" + searchNameField.getText() + "%");
            } else params.put("surname", "%");
            if(!comboSearchKlass.getSelectedItem().toString().equals("Все")) {
                params.put("klass", comboSearchKlass.getSelectedItem());
            } else params.put("klass", "%");

            String selectedStatus = comboSearchStatus.getSelectedItem().toString();
            List<Student> paramStudents = Student.getEntityDao().getWithParams(query, params);
            List<Student> filteredStudents = selectedStatus.equals("Все") ? paramStudents : new ArrayList<>();
            if(!selectedStatus.equals("Все")) {
                for(Student student: paramStudents) {
                    if(student.determineStudentStatus().equals(selectedStatus)) {
                        filteredStudents.add(student);
                    }
                }
            }
            setTable(filteredStudents);
        }
    }

    public class DisruptEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setInput(searchNameField, "Фамилия студента");
            comboSearchKlass.setSelectedIndex(0);
            comboSearchStatus.setSelectedIndex(0);
            initTable();
        }
    }
}
