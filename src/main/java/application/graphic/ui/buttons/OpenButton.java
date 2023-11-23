package application.graphic.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.graphic.ui.frames.MyFrame;

public class OpenButton extends ToolButton {
  public OpenButton(String name, String path, MyFrame frame) {
    super(name, path);
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(frame != null) frame.toggleVisible();
      }
    });
  }
}
