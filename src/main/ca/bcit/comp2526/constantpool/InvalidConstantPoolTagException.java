package ca.bcit.comp2526.constantpool;

public class InvalidConstantPoolTagException
        extends InvalidConstantPoolIndexException {

    private final short value;

    protected InvalidConstantPoolTagException(short value) {
        super(value);
        this.value = value;
    }

    public String getMessage() {
        return String.format("tag must be one of 1, 3, 44, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19, 20, was: %d", value);
    }

    public short getValue() {
        return value;
    }

}