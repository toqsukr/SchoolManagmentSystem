package application.graphic;

import application.entities.Student;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoFrame;

public class InfoStudentFrame extends InfoFrame<Student> {
  public InfoStudentFrame(EntityFrame<Student> parent, Student object) {
    super(parent, object);
  }
}
