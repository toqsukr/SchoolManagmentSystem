package application.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import application.entities.Subject;
import application.graphic.ui.CheckBoxList;

public class AddTeacherGUI extends AddGUI {

    private static final JTextField inputNameField = new JTextField("", 15);

    private static final JTextField inputSurnameField = new JTextField("", 15);

    private final CheckBoxList<Subject> subjectRadio;

    private static final JButton addBtn = new JButton("Добавить");

    private static final JButton cancelBtn = new JButton("Отмена");

    private static final JLabel nameLabel = new JLabel("Имя:");

    private static final JLabel surnameLabel = new JLabel("Фамилия:");

    private static final JLabel subjectLabel = new JLabel("Предмет:");
    
  public AddTeacherGUI() {
    super();

    List<Subject> subjects = Subject.getEntityDao().getAll();
    subjectRadio = new CheckBoxList<>(subjects);

    subjectRadio.setBackground(new Color(0xFFFFFF, false));
    subjectRadio.setFocusable(false);
    addBtn.setBackground(new Color(0xDFD9D9D9, false));
    cancelBtn.setBackground(new Color(0xDFD9D9D9, false));

    Box leftBox = Box.createVerticalBox();
    Box centerBox = Box.createVerticalBox();
    Box rightBox = Box.createVerticalBox();

    Box toolBox = Box.createHorizontalBox();

    Box nameBox = Box.createHorizontalBox();
    Box surnameBox = Box.createHorizontalBox();
    Box klassBox = Box.createHorizontalBox();
    Box entityBox = Box.createHorizontalBox();

    addBtn.setFocusable(false);

    cancelBtn.setFocusable(false);

    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());

    toolBox.add(Box.createRigidArea(new Dimension(40, 0)));
    toolBox.add(addBtn);
    toolBox.add(Box.createRigidArea(new Dimension(20, 0)));
    toolBox.add(cancelBtn);

    centerBox.add(Box.createRigidArea(new Dimension(20, 45)));

    nameBox.add(Box.createRigidArea(new Dimension(45, 0)));
    nameBox.add(nameLabel);
    nameBox.add(Box.createRigidArea(new Dimension(20, 0)));
    nameBox.add(inputNameField);
    centerBox.add(nameBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 20)));

    klassBox.add(Box.createRigidArea(new Dimension(45, 0)));
    klassBox.add(subjectLabel);
    klassBox.add(Box.createRigidArea(new Dimension(51, 0)));
    klassBox.add(subjectRadio);
    centerBox.add(klassBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 10)));

    surnameBox.add(Box.createRigidArea(new Dimension(15, 0)));
    Box surnameLabelBox = Box.createHorizontalBox();
    surnameLabelBox.add(Box.createRigidArea(new Dimension(30, 0)));
    surnameLabelBox.add(surnameLabel);
    surnameLabelBox.add(Box.createRigidArea(new Dimension(30, 0)));

    Box teamInnerBox = Box.createVerticalBox();
    teamInnerBox.add(surnameLabelBox);
    surnameBox.add(teamInnerBox);
    surnameBox.add(Box.createRigidArea(new Dimension(16, 0)));

    Box teamInputBox = Box.createVerticalBox();

    teamInputBox.add(Box.createRigidArea(new Dimension(0, 10)));
    teamInputBox.add(inputNameField);
    teamInputBox.add(nameLabel);
    teamInputBox.add(Box.createRigidArea(new Dimension(0, 10)));
    surnameBox.add(teamInputBox);
    centerBox.add(surnameBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 15)));

    entityBox.add(Box.createRigidArea(new Dimension(45, 0)));
    entityBox.add(surnameLabel);
    entityBox.add(Box.createRigidArea(new Dimension(67, 0)));
    entityBox.add(inputSurnameField);

    centerBox.add(entityBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 20)));
    centerBox.add(toolBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 50)));

    rightBox.add(Box.createRigidArea(new Dimension(45, 0)));

    container.add(leftBox, BorderLayout.WEST);
    container.add(centerBox, BorderLayout.CENTER);
    container.add(rightBox, BorderLayout.EAST);
  }
}
