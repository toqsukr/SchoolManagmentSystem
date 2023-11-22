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
import application.entities.Subject;
import application.entities.Teacher;
import application.graphic.ui.AddEntity;
import application.graphic.ui.CheckBoxList;
import application.graphic.ui.EntityFrame;
import application.interfaces.IAddFrame;
import application.utils.ListHelper;

public class AddTeacherGUI extends AddGUI implements IAddFrame<Teacher> {

  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField( 20);

  private final CheckBoxList<Subject> subjectCheckBox;

  private final CheckBoxList<Klass> klassCheckBox;

  private final AddEntity<Teacher, IAddFrame<Teacher>> addBtn = new AddEntity<>("Добавить", Teacher.class, this);

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel subjectLabel = new JLabel("Предмет:");

  private final JLabel klassLabel = new JLabel("Класс:");

  private final EntityFrame<Teacher> parent;
    
  public AddTeacherGUI(EntityFrame<Teacher> _parent) {
    super(_parent);
    parent = _parent;

    this.addWindowListener((WindowListener) new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        closeOperation();
      }
    });

    List<Subject> subjects = Subject.getEntityDao().getAll();
    subjectCheckBox = new CheckBoxList<>(subjects);

    List<Klass> klasses = Klass.getEntityDao().getAll();
    klassCheckBox = new CheckBoxList<>(klasses);
  
    subjectCheckBox.setBackground(new Color(0xFFFFFF, false));
    subjectCheckBox.setFocusable(false);
    addBtn.setBackground(new Color(0xDFD9D9D9, false));
    cancelBtn.setBackground(new Color(0xDFD9D9D9, false));

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    panel.setLayout(new GridLayout(5, 2, 10, 10));

    panel.add(nameLabel);
    panel.add(inputNameField);

    panel.add(surnameLabel);
    panel.add(inputSurnameField);

    panel.add(subjectLabel);
    panel.add(subjectCheckBox);

    panel.add(klassLabel);
    panel.add(klassCheckBox);

    panel.add(addBtn);
    panel.add(cancelBtn);

    add(panel);
  }

  public void closeOperation() {
    parent.setTable();
    dispose();
  }

  public Teacher getObjectToAdd() {
    String name = inputNameField.getText();
    String surname = inputSurnameField.getText();

    List<String> stringSubjects = subjectCheckBox.getSelectedItems();
    List<String> stringKlasses = klassCheckBox.getSelectedItems();

    List<Subject> subjects = new ListHelper<Subject>().getSelectedList(stringSubjects, Subject.class);
    List<Klass> klasses = new ListHelper<Klass>().getSelectedList(stringKlasses, Klass.class);

    return new Teacher(name, surname, subjects, klasses);
  }
}
