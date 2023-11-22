package application.interfaces;

public interface IAddFrame<T> extends IFrame {
  public void closeOperation();

  public T getObjectToAdd();
}
