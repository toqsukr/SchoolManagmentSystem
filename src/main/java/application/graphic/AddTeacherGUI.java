package application.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class AddTeacherGUI extends AddGUI {
      /**
     * This input is used to search for an entry in the table by the name of the
     * racer
     */
    private static final JTextField inputNameField = new JTextField("", 15);
    private static final JTextField inputSurnameField = new JTextField("", 15);

    /**
     * This input is used to search for an entry in the table by the team of the
     * racer
     */

    private static JComboBox<String> comboSubject = new JComboBox<>();

    private static final JButton addBtn = new JButton("Добавить");

    private static final JButton cancelBtn = new JButton("Отмена");

    private static final JLabel nameLabel = new JLabel("Имя:");
    private static final JLabel surnameLabel = new JLabel("Фамилия:");
    private static final JLabel subjectLabel = new JLabel("Предмет:");
    
  public AddTeacherGUI() {
    super();
    comboSubject.setBackground(new Color(0xFFFFFF, false));
    comboSubject.setFocusable(false);
    addBtn.setBackground(new Color(0xDFD9D9D9, false));
    cancelBtn.setBackground(new Color(0xDFD9D9D9, false));

    Box leftBox = Box.createVerticalBox();
    Box centerBox = Box.createVerticalBox();
    Box rightBox = Box.createVerticalBox();

    Box toolBox = Box.createHorizontalBox();

    Box nameBox = Box.createHorizontalBox();
    Box ageBox = Box.createHorizontalBox();
    Box teamBox = Box.createHorizontalBox();
    Box pointBox = Box.createHorizontalBox();

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
    centerBox.add(Box.createRigidArea(new Dimension(0, 25)));

    ageBox.add(Box.createRigidArea(new Dimension(45, 0)));
    ageBox.add(subjectLabel);
    ageBox.add(Box.createRigidArea(new Dimension(51, 0)));
    ageBox.add(comboSubject);
    centerBox.add(ageBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 15)));

    teamBox.add(Box.createRigidArea(new Dimension(15, 0)));
    Box surnameLabelBox = Box.createHorizontalBox();
    surnameLabelBox.add(Box.createRigidArea(new Dimension(30, 0)));
    surnameLabelBox.add(surnameLabel);
    surnameLabelBox.add(Box.createRigidArea(new Dimension(30, 0)));

    Box teamInnerBox = Box.createVerticalBox();
    teamInnerBox.add(surnameLabelBox);
    teamBox.add(teamInnerBox);
    teamBox.add(Box.createRigidArea(new Dimension(16, 0)));

    Box teamInputBox = Box.createVerticalBox();

    teamInputBox.add(Box.createRigidArea(new Dimension(0, 10)));
    teamInputBox.add(inputNameField);
    teamInputBox.add(nameLabel);
    teamInputBox.add(Box.createRigidArea(new Dimension(0, 10)));
    teamBox.add(teamInputBox);
    centerBox.add(teamBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 15)));

    pointBox.add(Box.createRigidArea(new Dimension(45, 0)));
    pointBox.add(surnameLabel);
    pointBox.add(Box.createRigidArea(new Dimension(67, 0)));
    pointBox.add(inputSurnameField);

    centerBox.add(pointBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 20)));
    centerBox.add(toolBox);
    centerBox.add(Box.createRigidArea(new Dimension(0, 50)));

    rightBox.add(Box.createRigidArea(new Dimension(45, 0)));

    container.add(leftBox, BorderLayout.WEST);
    container.add(centerBox, BorderLayout.CENTER);
    container.add(rightBox, BorderLayout.EAST);
  }
}
