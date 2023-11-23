package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import application.graphic.InfoGUI;
import application.interfaces.IEntityName;

public class InfoButton<T extends IEntityName, E extends InfoGUI<T>> extends OpenButton {
  private E infoWindow = null;

  public InfoButton(EntityFrame<T> parent, Class<T> entityClass, Class<E> windowClass) {
    super("Инфо", "images/info.png", null);

    this.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          List<? extends IEntityName> selectedObjects = parent.getSelectedObjects();
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
