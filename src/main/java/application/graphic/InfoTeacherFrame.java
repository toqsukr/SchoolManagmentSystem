package application.graphic;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import application.entities.Klass;
import application.entities.Subject;
import application.entities.Teacher;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoFrame;

public class InfoTeacherFrame extends InfoFrame<Teacher> {
  JPanel panel = new JPanel();

  JPanel subjectListPanel = new JPanel();

  JPanel klassListPanel = new JPanel();

  JLabel subjectLabel = new JLabel("Предметы: ");
  private DefaultListModel<String> subjectListModel = new DefaultListModel<>();
  private JList<String> subjectList = new JList<>(subjectListModel);

  JLabel klassLabel = new JLabel("Классы: ");
  private DefaultListModel<String> klassListModel = new DefaultListModel<>();
  private JList<String> klassList = new JList<>(klassListModel);

  public InfoTeacherFrame(EntityFrame<Teacher> parent, Teacher object) {
    super(parent, object);

    object.getSubjects().forEach((Subject subject) -> {
      subjectListModel.addElement(subject.getName());
    });

    object.getKlasses().forEach((Klass klass) -> {
      klassListModel.addElement(klass.getName());
    });

    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    panel.setLayout(new GridLayout(2, 1, 10, 10));

    subjectListPanel.setLayout(new GridLayout(1, 2));

    klassListPanel.setLayout(new GridLayout(1, 2));

    subjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
    klassLabel.setHorizontalAlignment(SwingConstants.CENTER);

    subjectListPanel.add(subjectLabel);
    subjectListPanel.add(new JScrollPane(subjectList));

    klassListPanel.add(klassLabel);
    klassListPanel.add(new JScrollPane(klassList));

    panel.add(subjectListPanel);
    panel.add(klassListPanel);

    add(panel);
  }
}
