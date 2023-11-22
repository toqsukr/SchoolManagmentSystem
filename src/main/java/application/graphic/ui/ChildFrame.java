package application.graphic.ui;

public class ChildFrame extends MyFrame {
  private MyFrame parentWindow;
  public ChildFrame(String name, MyFrame _parentWindow) {
    super(name);
    this.setBounds(650, 200, 350, 350);
    this.setResizable(false);
    parentWindow = _parentWindow;
  }

  public MyFrame getParentWindow() {
    return parentWindow;
  }
}