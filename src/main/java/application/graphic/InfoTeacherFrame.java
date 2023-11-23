package application.graphic;

import application.entities.Teacher;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoFrame;

public class InfoTeacherFrame extends InfoFrame<Teacher> {
  public InfoTeacherFrame(EntityFrame<Teacher> parent, Teacher object) {
    super(parent, object);
  }
}
