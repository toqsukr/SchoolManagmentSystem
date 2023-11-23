package application.graphic;

import application.entities.Student;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;

public class EditStudentFrame extends EditFrame<Student> {
  public EditStudentFrame(EntityFrame<Student> parent, Student object) {
    super(parent, object);
  }
}
