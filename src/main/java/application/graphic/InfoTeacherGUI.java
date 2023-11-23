package application.graphic;

import application.entities.Teacher;
import application.graphic.ui.EntityFrame;

public class InfoTeacherGUI extends InfoGUI<Teacher> {
  public InfoTeacherGUI(EntityFrame<Teacher> parentWindow, Teacher teacher) {
    super(parentWindow, teacher);
  }
}
