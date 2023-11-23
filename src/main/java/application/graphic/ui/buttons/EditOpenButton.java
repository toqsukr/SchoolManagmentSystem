package application.graphic.ui.buttons;

import application.entities.Person;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.TargetChildFrame;

public class EditOpenButton<T extends Person> extends TargetOpenButton<T> {
  public EditOpenButton(EntityFrame<T> parent, Class<T> entityClass, Class<? extends TargetChildFrame<T>> windowClass) {
    super(parent, entityClass, windowClass, "images/edit.png");
  }
}
