package application.graphic;

import application.graphic.ui.ChildFrame;
import application.graphic.ui.MyFrame;

public class AddGUI extends ChildFrame {
  public AddGUI(MyFrame parent) {
    super("Добавление", parent);
    this.setBounds(650, 200, 350, 350);
    this.setResizable(false);
  }
}
