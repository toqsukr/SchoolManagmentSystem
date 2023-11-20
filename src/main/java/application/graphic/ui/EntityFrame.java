package application.graphic.ui;

import javax.swing.JFrame;

public class EntityFrame extends JFrame {
  public EntityFrame(String name) {
    super(name);
    this.setBounds(200, 150, 800, 600);
    this.setResizable(false);
  }

  public void toggleVisible() {
    this.setVisible(!this.isVisible());
  }
}
