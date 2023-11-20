package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenButton extends ToolButton {
  public OpenButton(String name, String path, MyFrame frame) {
    super(name, path);
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.toggleVisible();
      }
    });
  }
}
