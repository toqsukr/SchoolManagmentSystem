package application.graphic;

import application.entities.Teacher;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoGUI;

public class InfoTeacherFrame extends InfoGUI<Teacher> {
  public InfoTeacherFrame(EntityFrame<Teacher> parentWindow, Teacher teacher) {
    super(parentWindow, teacher);
  }
}
