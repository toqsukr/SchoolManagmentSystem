package application.graphic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import application.entities.Klass;
import application.entities.Progress;
import application.entities.Student;
import application.entities.Subject;
import application.graphic.ui.CheckBoxList;
import application.graphic.ui.buttons.SaveEntityButton;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;
import application.interfaces.IAddFrame;
import application.utils.Checker;
import application.utils.ListHelper;

public class EditStudentFrame extends EditFrame<Student> implements IAddFrame<Student> {

  private final JTextField inputNameField = new JTextField(20);

  private final JTextField inputSurnameField = new JTextField(20);

  private final CheckBoxList<Klass> klassCheckBox;

  private final SaveEntityButton<Student> saveBtn = new SaveEntityButton<>("Сохранить", Student.class, this);

  private final JButton cancelBtn = new JButton("Отмена");

  private final JLabel nameLabel = new JLabel("Имя:");

  private final JLabel surnameLabel = new JLabel("Фамилия:");

  private final JLabel klassLabel = new JLabel("Класс:");

  private final List<JTextField> markInputs = new ArrayList<>();

  private final JPanel panel = new JPanel();

  private final JPanel markPanel = new JPanel();

  private final JPanel buttonPanel = new JPanel();

  private EntityFrame<Student> parentWindow;

  public EditStudentFrame(EntityFrame<Student> _parentWindow, Student object) {
    super(_parentWindow, object);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

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

    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
    panel.setLayout(new GridLayout(4, 2, 10, 10));

    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

    panel.add(nameLabel);
    panel.add(inputNameField);

    panel.add(surnameLabel);
    panel.add(inputSurnameField);

    panel.add(klassLabel);
    panel.add(klassCheckBox);

    initMarkInputs();

    buttonPanel.add(saveBtn);
    buttonPanel.add(cancelBtn);
    setObjectData();

    add(panel);
    add(markPanel);
    add(buttonPanel);
  }

  private void initMarkInputs() {
    List<Subject> subjects = Subject.getEntityDao().getAll();
    markPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    markPanel.setLayout(new GridLayout(subjects.size(), 2, 10, 10));
    for (Subject subject : subjects) {
      JLabel label = new JLabel(subject.getName());
      JTextField input = new JTextField();

      String query = "from Progress p where p.progressID.subject = :subject AND p.progressID.student = :student";
      Map<String, Object> params = new HashMap<>();
      params.put("subject", subject);
      params.put("student", object);
      List<Progress> progresses = Progress.getEntityDao().getWithParams(query, params);
      if (progresses.size() == 0)
        input.setText("0");
      else {
        input.setText(progresses.get(0).getAverageMark().toString());
      }

      markInputs.add(input);
      markPanel.add(label);
      markPanel.add(input);
    }
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
    parentWindow.initTable();
    dispose();
  }

  public Student getObjectToAdd() {
    try {
      object.setName(inputNameField.getText());
      object.setSurname(inputSurnameField.getText());
      object.setKlass(Klass.getEntityDao().findObject(klassCheckBox.getSelectedItems().get(0)));
      List<Progress> progresses = object.getProgress();
      List<Subject> subjects = Subject.getEntityDao().getAll();

      for (JTextField input : markInputs) {
        Checker.isCorrectNumber(input.getText());
        Checker.isCorrectMark(input.getText());
      }

      List<Subject> progressSubjects = object.getProgress().stream()
          .map((Progress progress) -> progress.getID().getSubject()).toList();

      for (int i = 0; i < subjects.size(); i++) {
        Double newMark = Double.parseDouble(markInputs.get(i).getText());
        if (progressSubjects.size() > 0 && ListHelper.isAtList(progressSubjects, subjects.get(i))) {
          final int index = i;
          progresses.forEach((Progress progress) -> {
            if (progress.getID().getSubject().getName().equals(subjects.get(index).getName())) {
              progress.setAverageMark(newMark);
              Progress.getEntityDao().updateObject(progress);
            }
          });
        } else {
          Progress studentProgress = new Progress(subjects.get(i), object);
          studentProgress.setAverageMark(newMark);
          Progress.getEntityDao().saveObject(studentProgress);
          object.getProgress().add(studentProgress);
        }
        ;
      }
    } catch (Exception error) {
      JOptionPane.showMessageDialog(parentWindow, error.getMessage(), "Ошибка редактирования",
          JOptionPane.PLAIN_MESSAGE);
    }
    return object;
  }
}
