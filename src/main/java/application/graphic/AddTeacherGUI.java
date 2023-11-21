package application.graphic;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.entities.Klass;
import application.entities.Subject;
import application.graphic.ui.CheckBoxList;

public class AddTeacherGUI extends AddGUI {

    private final JTextField inputNameField = new JTextField(20);

    private final JTextField inputSurnameField = new JTextField( 20);

    private final CheckBoxList<Subject> subjectCheckBox;

    private final CheckBoxList<Klass> klassCheckBox;

    private final JButton addBtn = new JButton("Добавить");

    private final JButton cancelBtn = new JButton("Отмена");

    private final JLabel nameLabel = new JLabel("Имя:");

    private final JLabel surnameLabel = new JLabel("Фамилия:");

    private final JLabel subjectLabel = new JLabel("Предмет:");

    private final JLabel klassLabel = new JLabel("Класс:");
    
  public AddTeacherGUI() {
    super();

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
}
