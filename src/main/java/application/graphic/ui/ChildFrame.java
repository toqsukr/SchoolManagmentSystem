package application.graphic.ui;

public class ChildFrame extends MyFrame {
  protected MyFrame parentWindow;
  public ChildFrame(String name, MyFrame _parentWindow) {
    super(name);
    parentWindow = _parentWindow;
  }

  public void setParent(MyFrame _parentWindow) {
    parentWindow = _parentWindow;
  } 
}