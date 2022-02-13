package ru.inovus.number.generator.error;

/**
 * NumbersIsOverException означает, что невозможно выдать новый номер, т.к. все уже были выданы
 */
public class NumbersIsOverException extends RuntimeException {

    public NumbersIsOverException() {
        super("Numbers is over");
    }

}
