package application.graphic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.entities.Klass;
import application.entities.Student;
import application.graphic.ui.AddEntity;
import application.graphic.ui.CheckBoxList;
import application.graphic.ui.EntityFrame;
import application.interfaces.IAddFrame;

public class AddStudentGUI extends AddGUI implements IAddFrame<Student> {

  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField( 20);

  private final CheckBoxList<Klass> klassCheckBox;

  private final AddEntity<Student, IAddFrame<Student>> addBtn = new AddEntity<>("Добавить", Student.class, this);

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel klassLabel = new JLabel("Класс:");

  private final EntityFrame<AddStudentGUI> parent;
    
  public AddStudentGUI(EntityFrame<AddStudentGUI> _parent) {
    super(_parent);
    parent = _parent;

    this.addWindowListener((WindowListener) new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        closeOperation();
      }
    });

    List<Klass> klasses = Klass.getEntityDao().getAll();
    klassCheckBox = new CheckBoxList<>(klasses);
  
    addBtn.setBackground(new Color(0xDFD9D9D9, false));
    cancelBtn.setBackground(new Color(0xDFD9D9D9, false));

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    panel.setLayout(new GridLayout(5, 2, 10, 10));

    panel.add(nameLabel);
    panel.add(inputNameField);

    panel.add(surnameLabel);
    panel.add(inputSurnameField);

    panel.add(klassLabel);
    panel.add(klassCheckBox);

    panel.add(addBtn);
    panel.add(cancelBtn);

    add(panel);
  }

  public void clearFields() {
    inputNameField.setText("");
    inputSurnameField.setText("");
    klassCheckBox.resetCheckBoxes();
  }

  public void closeOperation() {
    parent.setTable();
    dispose();
  }

  public Student getObjectToAdd() {
    String name = inputNameField.getText();
    String surname = inputSurnameField.getText();

    List<String> stringKlasses = klassCheckBox.getSelectedItems();

    Klass klass = new Klass(stringKlasses.get(0));

    return new Student(name, surname, klass);
  }
}
