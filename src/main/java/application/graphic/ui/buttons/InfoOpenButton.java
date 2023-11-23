package application.graphic.ui.buttons;

import application.entities.Person;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.TargetChildFrame;

public class InfoOpenButton<T extends Person> extends TargetOpenButton<T> {
  public InfoOpenButton(EntityFrame<T> parent, Class<T> entityClass, Class<? extends TargetChildFrame<T>> windowClass) {
    super(parent, entityClass, windowClass, "images/info.png");
  }
}
