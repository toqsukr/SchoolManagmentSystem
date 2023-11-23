package application.graphic.ui.frames;

import javax.swing.JFrame;

import application.entities.Person;

public class InfoGUI<T extends Person> extends ChildFrame {
  private EntityFrame<?> parentWindow;

  private T object;

  public InfoGUI(EntityFrame<?> _parentWindow, T _object) {
    super(_object.getName() + " " + _object.getSurname(), _parentWindow);
    parentWindow = _parentWindow;
    object = _object;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  @Override
  public EntityFrame<?> getParentWindow() {
    return parentWindow;
  }
}