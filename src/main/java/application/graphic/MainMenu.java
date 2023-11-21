package application.graphic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

import application.graphic.ui.MyFrame;

public class MainMenu extends MyFrame {
    private final JButton teacherBtn = new JButton("      Учителя   ");

    private final JButton studentBtn = new JButton("      Ученики   ");

    private final JButton exitBtn = new JButton("      Выход     ");

    private JLabel title = new JLabel("Система управления школой");

    private TeacherGUI teacherGUI;

    private StudentGUI studentGUI;

    public MainMenu() {
      super("Главное меню");
      teacherGUI = new TeacherGUI(this);
      studentGUI = new StudentGUI(this);

      this.addWindowListener((WindowListener) new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      });

      this.setBounds(650, 200, 300, 220);
      this.setResizable(false);

      initButton(teacherBtn);
      initButton(studentBtn);
      initButton(exitBtn);
      
      teacherBtn.addActionListener(new TeacherEventListener());
      studentBtn.addActionListener(new StudentEventListener());
      exitBtn.addActionListener(new ExitEventListener());

      Box leftBox = Box.createVerticalBox();
      Box centerBox = Box.createVerticalBox();
      Box rightBox = Box.createVerticalBox();

      Box topBox = Box.createHorizontalBox();
      Box racerBox = Box.createHorizontalBox();
      Box teamBox = Box.createHorizontalBox();
      Box exitBox = Box.createHorizontalBox();

      Container container = this.getContentPane();
      container.setLayout(new BorderLayout());

      topBox.add(Box.createRigidArea(new Dimension(0, 40)));
      topBox.add(title);
      topBox.add(Box.createRigidArea(new Dimension(0, 40)));
      centerBox.add(topBox);

      racerBox.add(teacherBtn);
      centerBox.add(Box.createRigidArea(new Dimension(0, 10)));
      centerBox.add(racerBox);

      teamBox.add(studentBtn);
      centerBox.add(Box.createRigidArea(new Dimension(0, 10)));
      centerBox.add(teamBox);

      exitBox.add(exitBtn);
      centerBox.add(Box.createRigidArea(new Dimension(0, 10)));
      centerBox.add(exitBox);

      container.add(leftBox, BorderLayout.WEST);
      container.add(centerBox, BorderLayout.CENTER);
      container.add(rightBox, BorderLayout.EAST);   
    }

    private void initButton(JButton button) {
        button.setBackground(new Color(0xDFD9D9D9, false));
        button.setFocusable(false);
        button.setMargin(new Insets(1, 2, 1, 10));
    }



    private class TeacherEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
        teacherGUI.toggleVisible();
      }
  }

  private class StudentEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
        studentGUI.toggleVisible();
      }
  }

  private class ExitEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
          System.exit(0);
      }
  }
}