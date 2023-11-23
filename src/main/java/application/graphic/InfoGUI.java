package application.graphic;

import javax.swing.JFrame;

import application.graphic.ui.ChildFrame;
import application.graphic.ui.EntityFrame;
import application.interfaces.IEntityName;

public class InfoGUI<T extends IEntityName> extends ChildFrame {
  private EntityFrame<?> parentWindow;

  private T object;

  public InfoGUI(EntityFrame<?> _parentWindow, T _object) {
    super(_object.getName(), _parentWindow);
    parentWindow = _parentWindow;
    object = _object;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  @Override
  public EntityFrame<?> getParentWindow() {
    return parentWindow;
  }
}
