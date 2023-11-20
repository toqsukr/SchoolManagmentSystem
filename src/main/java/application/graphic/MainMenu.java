package application.graphic;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private static JFrame mainMenu = new JFrame("Главное меню");

    private final JButton teacherBtn = new JButton("      Учителя   ");

    private final JButton studentBtn = new JButton("      Ученики   ");

    private final JButton exitBtn = new JButton("      Выход     ");

    private JLabel title = new JLabel("Система управления школой");

    public MainMenu() {
      setupWindow();      
    }

    private void setupWindow() {
      mainMenu.setBounds(650, 200, 300, 220);
      mainMenu.setResizable(false);

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

      Container container = mainMenu.getContentPane();
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

    public void showWindow() {
      mainMenu.setVisible(true);
    }

    private void initButton(JButton button) {
        button.setBackground(new Color(0xDFD9D9D9, false));
        button.setFocusable(false);
        button.setMargin(new Insets(1, 2, 1, 10));
    }

    public void setMainMenuEnable(boolean value) {
        mainMenu.setEnabled(value);
    }

    private class TeacherEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
      }
  }

  private class StudentEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
      }
  }

  private class ExitEventListener implements ActionListener {

      /***
       *
       * @param e the event to be processed
       */
      public void actionPerformed(ActionEvent e) {
          System.exit(1);
      }
  }
}