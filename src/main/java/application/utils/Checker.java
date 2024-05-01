package application.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.exceptions.InvalidAverageMarkException;
import application.exceptions.InvalidNumberFormatException;

public class Checker {
    public static void isCorrectNumber(String value) throws InvalidNumberFormatException {
        String regex = "^\\s*(?:\\d+(?:\\.\\d+)?|\\.\\d+)\\s*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(value);

        if (value.isEmpty() || !matcher.matches())
            throw new InvalidNumberFormatException();
    }

    public static void isCorrectMark(String mark) throws InvalidAverageMarkException {
        if ((Double.parseDouble(mark) < 1 && Double.parseDouble(mark) > 0)
                || Double.parseDouble(mark) > 5) {
            throw new InvalidAverageMarkException();
        }
    }
}
