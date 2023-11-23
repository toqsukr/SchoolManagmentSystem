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
import application.entities.Subject;
import application.entities.Teacher;
import application.graphic.ui.CheckBoxList;
import application.graphic.ui.buttons.SaveEntityButton;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;
import application.interfaces.IAddFrame;
import application.utils.ListHelper;

public class EditTeacherFrame extends EditFrame<Teacher> implements IAddFrame<Teacher> {
  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField( 20);

  private final CheckBoxList<Subject> subjectCheckBox;

  private final CheckBoxList<Klass> klassCheckBox;

  private final SaveEntityButton<Teacher> saveBtn = new SaveEntityButton<>("Сохранить", Teacher.class, this);

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel subjectLabel = new JLabel("Предмет:");

  private final JLabel klassLabel = new JLabel("Класс:");

  private EntityFrame<Teacher> parentWindow;

  public EditTeacherFrame(EntityFrame<Teacher> _parentWindow, Teacher object) {
    super(_parentWindow, object);

    parentWindow = _parentWindow;

    List<Subject> subjects = Subject.getEntityDao().getAll();
    subjectCheckBox = new CheckBoxList<>(subjects, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    List<Klass> klasses = Klass.getEntityDao().getAll();
    klassCheckBox = new CheckBoxList<>(klasses, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  
    subjectCheckBox.setBackground(new Color(0xFFFFFF, false));
    subjectCheckBox.setFocusable(false);
    saveBtn.setBackground(new Color(0xDFD9D9D9, false));
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

    panel.add(saveBtn);
    panel.add(cancelBtn);
    setObjectData();

    add(panel);
  }

  private void setObjectData() {
    inputNameField.setText(object.getName());
    inputSurnameField.setText(object.getSurname());
    klassCheckBox.fillCheckboxes(object.getKlasses());
    subjectCheckBox.fillCheckboxes(object.getSubjects());
  }

  public void clearFields() {
    inputNameField.setText("");
    inputSurnameField.setText("");
    klassCheckBox.resetCheckBoxes();
    subjectCheckBox.resetCheckBoxes();
  }

  public void closeOperation() {
    parentWindow.setTable();
    dispose();
  }

  private void updateSubjects() {
    List<String> selectedList = subjectCheckBox.getSelectedItems();
    for(String name: subjectCheckBox.getSelectedItems()) {
      if(!ListHelper.isAtList(selectedList, name)) object.appendSubject(Subject.getEntityDao().findObject(name));
    }
  }

  private void updateKlasses() {
    List<String> selectedList = klassCheckBox.getSelectedItems();
    for(String name: selectedList) {
      if(!ListHelper.isAtList(selectedList, name)) object.appendKlass(Klass.getEntityDao().findObject(name));
    }
  }

  public Teacher getObjectToAdd() {
    object.setName(inputNameField.getText());
    object.setSurname(inputSurnameField.getText());
    updateSubjects();
    updateKlasses();
    
    return object;
  }
}