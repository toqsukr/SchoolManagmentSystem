package application.graphic;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import application.entities.Klass;
import application.entities.Student;
import application.graphic.ui.CheckBoxList;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;

public class EditStudentFrame extends EditFrame<Student> {

  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField( 20);

  private final CheckBoxList<Klass> klassCheckBox;

  private final JButton addBtn = new JButton("Сохранить");

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel klassLabel = new JLabel("Класс:");
  public EditStudentFrame(EntityFrame<Student> parent, Student object) {
    super(parent, object);
    List<Klass> klasses = Klass.getEntityDao().getAll();
    klassCheckBox = new CheckBoxList<>(klasses, ListSelectionModel.SINGLE_SELECTION);
  
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
    setObjectData();

    add(panel);
  }

  private void setObjectData() {
    inputNameField.setText(object.getName());
    inputSurnameField.setText(object.getSurname());
    klassCheckBox.fillCheckbox(object.getKlass());
  }
}
