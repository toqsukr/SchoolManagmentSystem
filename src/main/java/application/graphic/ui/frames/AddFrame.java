package application.graphic.ui.frames;

public class AddFrame extends ChildFrame {
  public AddFrame(MyFrame parent) {
    super("Добавление", parent);
    this.setBounds(650, 200, 350, 350);
    this.setResizable(false);
  }
}
