package application.graphic.ui;

import javax.swing.JFrame;

import application.interfaces.IFrame;

public class MyFrame extends JFrame implements IFrame {

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
