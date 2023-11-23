package application.graphic;

import application.entities.Student;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoGUI;

public class InfoStudentFrame extends InfoGUI<Student> {
  public InfoStudentFrame(EntityFrame<Student> parentWindow, Student student) {
    super(parentWindow, student);
  }
}
