package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.ClassFileException;

public class InvalidConstantPoolIndexException
        extends ClassFileException {
    private int value;

    protected InvalidConstantPoolIndexException(int value) {
        super(String.format("nameIndex must be > 0, was: %d", value));
        this.value = value;
    }

    protected InvalidConstantPoolIndexException(String msg, int value) {
        super(String.format("%s must be > 0, was: %d",msg, value));
        this.value = value;
    }

    public int getIndex() {
        return this.value;
    }
}