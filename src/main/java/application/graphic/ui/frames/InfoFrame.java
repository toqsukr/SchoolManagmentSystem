package application.graphic.ui.frames;

import application.entities.Person;

public class InfoFrame<T extends Person> extends TargetChildFrame<T> {
  public InfoFrame(EntityFrame<T> parent, T object) {
    super(object.getName() + " " + object.getSurname() +" - Информация", parent, object);
  }
}
