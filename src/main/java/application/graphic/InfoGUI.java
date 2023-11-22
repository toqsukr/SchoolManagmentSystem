package application.graphic;

import application.graphic.ui.ChildFrame;
import application.graphic.ui.EntityFrame;

public class InfoGUI extends ChildFrame {
  private EntityFrame<?> parentWindow;

  public InfoGUI(EntityFrame<?> _parentWindow) {
    super("Информация", _parentWindow);
    parentWindow = _parentWindow;
  }

  @Override
  public EntityFrame<?> getParentWindow() {
    return parentWindow;
  }
}
