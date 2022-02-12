package ru.inovus.number.generator.error;

public class NumberNotFoundException extends RuntimeException {

    public NumberNotFoundException() {
        super("Number not found");
    }

}
