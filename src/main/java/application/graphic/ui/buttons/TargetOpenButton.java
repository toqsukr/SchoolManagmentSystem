package application.graphic.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import application.entities.Person;
import application.graphic.ui.frames.EntityFrame;
import application.graphic.ui.frames.TargetChildFrame;

public class TargetOpenButton<T extends Person> extends OpenButton {
  private TargetChildFrame<T> frame = null;

  public TargetOpenButton(EntityFrame<T> parent, Class<T> entityClass, Class<? extends TargetChildFrame<T>> windowClass, String path) {
    super("targetbtn", path, null);

    this.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          List<? extends Person> selectedObjects = parent.getSelectedObjects();
          if (selectedObjects.size() == 1) {
              if(frame == null || !frame.isVisible())
                try {
                  frame = windowClass.getDeclaredConstructor(EntityFrame.class, entityClass).newInstance(parent, selectedObjects.get(0));
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
                  e1.printStackTrace();
                }
              frame.toggleVisible();
          }
        }
    });
  }
}
