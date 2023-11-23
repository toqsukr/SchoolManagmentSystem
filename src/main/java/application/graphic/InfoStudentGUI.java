package application.graphic;

import application.entities.Student;
import application.graphic.ui.EntityFrame;

public class InfoStudentGUI extends InfoGUI<Student> {
  public InfoStudentGUI(EntityFrame<Student> parentWindow, Student student) {
    super(parentWindow, student);
  }
}
