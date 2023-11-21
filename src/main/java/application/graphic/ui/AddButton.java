package application.graphic.ui;

import application.graphic.AddGUI;

public class AddButton<T extends AddGUI> extends OpenButton {
  public AddButton(T frame) {
    super("Добавить", "images/add.png", frame);
  };
}


