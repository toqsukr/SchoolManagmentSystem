package application.graphic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import application.graphic.ui.buttons.SaveEntityButton;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;
import application.interfaces.IAddFrame;

public class EditStudentFrame extends EditFrame<Student> implements IAddFrame<Student>  {

  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField( 20);

  private final CheckBoxList<Klass> klassCheckBox;

  private final SaveEntityButton<Student> saveBtn = new SaveEntityButton<>("Сохранить", Student.class, this);

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel klassLabel = new JLabel("Класс:");

  private EntityFrame<Student> parentWindow;

  public EditStudentFrame(EntityFrame<Student> _parentWindow, Student object) {
    super(_parentWindow, object);

    parentWindow = _parentWindow;

    List<Klass> klasses = Klass.getEntityDao().getAll();
    klassCheckBox = new CheckBoxList<>(klasses, ListSelectionModel.SINGLE_SELECTION);
  
    saveBtn.setBackground(new Color(0xDFD9D9D9, false));
    cancelBtn.setBackground(new Color(0xDFD9D9D9, false));

    cancelBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        closeOperation();
      }
    });

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    panel.setLayout(new GridLayout(5, 2, 10, 10));

    panel.add(nameLabel);
    panel.add(inputNameField);

    panel.add(surnameLabel);
    panel.add(inputSurnameField);

    panel.add(klassLabel);
    panel.add(klassCheckBox);

    panel.add(saveBtn);
    panel.add(cancelBtn);
    setObjectData();

    add(panel);
  }

  private void setObjectData() {
    inputNameField.setText(object.getName());
    inputSurnameField.setText(object.getSurname());
    klassCheckBox.fillCheckbox(object.getKlass());
  }

  public void clearFields() {
    inputNameField.setText("");
    inputSurnameField.setText("");
    klassCheckBox.resetCheckBoxes();
  }

  public void closeOperation() {
    parentWindow.setTable();
    dispose();
  }

  public Student getObjectToAdd() {
    object.setName(inputNameField.getText());
    object.setSurname(inputSurnameField.getText());
    object.setKlass(Klass.getEntityDao().findObject(klassCheckBox.getSelectedItems().get(0)));
    
    return object;
  }
}
