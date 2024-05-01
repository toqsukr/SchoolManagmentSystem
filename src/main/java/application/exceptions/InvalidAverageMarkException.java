package application.exceptions;

public class InvalidAverageMarkException extends Exception {
    /***
     * InvalidAverageMarkException constructor
     */
    public InvalidAverageMarkException() {
        super("Средняя оценка должна быть в диапазоне от 1.0 до 5.0");
    }
}