package application.graphic;

import application.entities.Teacher;
import application.graphic.ui.frames.EditFrame;
import application.graphic.ui.frames.EntityFrame;

public class EditTeacherFrame extends EditFrame<Teacher> {
  public EditTeacherFrame(EntityFrame<Teacher> parent, Teacher object) {
    super(parent, object);
  }
}