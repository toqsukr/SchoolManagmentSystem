package application.exceptions;

public class InvalidNumberFormatException extends Exception {
    /***
     * InvalidNumberFormatException constructor
     */
    public InvalidNumberFormatException() {
        super("Неверный формат числа!");
    }
}
