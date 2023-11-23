package application.graphic.ui.frames;

import javax.swing.JFrame;

import application.entities.Person;

public class TargetChildFrame<T extends Person> extends ChildFrame {
  private EntityFrame<?> parentWindow;

  protected T object;

  public TargetChildFrame(String name, EntityFrame<?> _parentWindow, T _object) {
    super(name, _parentWindow);
    parentWindow = _parentWindow;
    object = _object;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  @Override
  public EntityFrame<?> getParentWindow() {
    return parentWindow;
  }
}