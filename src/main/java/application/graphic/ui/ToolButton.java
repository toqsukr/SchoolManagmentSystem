package application.graphic.ui;

import java.awt.*;

import javax.swing.JButton;

public class ToolButton extends JButton {
  public ToolButton(String name) {
    super();
    this.setBackground(new Color(0xDFD9D9D9, false));
    this.setFocusable(false);
    this.setMargin(new Insets(1, 2, 1, 10));
  }
}
