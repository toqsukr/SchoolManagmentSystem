package application.graphic.ui;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

  public MyFrame(String name) {
    super(name);
  }

  public void toggleEnable() {
    this.setEnabled(!this.isEnabled());
  }

  public void toggleVisible() {
    this.setVisible(!this.isVisible());
  }

}
