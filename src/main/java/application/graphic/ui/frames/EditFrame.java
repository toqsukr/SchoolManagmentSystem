package application.graphic.ui.frames;

import application.entities.Person;

public class EditFrame<T extends Person> extends TargetChildFrame<T> {
    public EditFrame(EntityFrame<T> parent, T object) {
      super(object.getName() + " " + object.getSurname() +" - Редактирование", parent, object);
    }
}
