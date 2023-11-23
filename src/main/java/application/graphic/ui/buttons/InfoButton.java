package application.graphic.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import application.entities.Person;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.InfoGUI;

public class InfoButton<T extends Person, E extends InfoGUI<T>> extends OpenButton {
  private E infoWindow = null;

  public InfoButton(EntityFrame<T> parent, Class<T> entityClass, Class<E> windowClass) {
    super("Инфо", "images/info.png", null);

    this.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          List<? extends Person> selectedObjects = parent.getSelectedObjects();
          if (selectedObjects.size() == 1) {
              if(infoWindow == null || !infoWindow.isVisible())
                try {
                  infoWindow = windowClass.getDeclaredConstructor(EntityFrame.class, entityClass).newInstance(parent, selectedObjects.get(0));
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
                  e1.printStackTrace();
                }
              infoWindow.toggleVisible();
          }
        }
    });
  }
}
