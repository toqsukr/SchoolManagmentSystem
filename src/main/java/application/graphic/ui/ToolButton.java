package application.graphic.ui;

import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {
  public ToolButton(String name, String path) {
    super();
    URL squadIcon = this.getClass().getClassLoader().getResource(path);
    this.setIcon(new ImageIcon(new ImageIcon(squadIcon).getImage().getScaledInstance(50, 50, 4)));
    this.setBackground(new Color(0xDFD9D9D9, false));
    this.setFocusable(false);
    this.setMargin(new Insets(1, 2, 1, 10));
  }
}
