package application.graphic.ui;

import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

  public ToolBar() {
    super();
    this.setFloatable(false);
  }

  public void addButton(ToolButton button) {
    this.add(button);
  }
}
