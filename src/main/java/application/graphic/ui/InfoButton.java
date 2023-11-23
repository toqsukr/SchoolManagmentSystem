package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import application.graphic.InfoGUI;
import application.interfaces.IEntityName;

public class InfoButton extends OpenButton {
  private InfoGUI<?> infoWindow;

  public InfoButton(EntityFrame<?> parent) {
    super("Инфо", "images/info.png", null);

    this.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          List<? extends IEntityName> selectedObjects = parent.getSelectedObjects();
          if (selectedObjects.size() == 1) {
              infoWindow = new InfoGUI<>(parent, selectedObjects.get(0));
              infoWindow.toggleVisible();
          }
        }
    });
  }
}
