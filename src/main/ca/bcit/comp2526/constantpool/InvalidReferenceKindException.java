package ca.bcit.comp2526.constantpool;

public class InvalidReferenceKindException
        extends InvalidConstantPoolTagException {

    private final short value;

    protected InvalidReferenceKindException(short value) {
        super(value);
        this.value = value;
    }

    public String getMessage() {
        return String.format("referenceKind must be between 1 and 9, was: %d", value);
    }

    public short getValue() {
        return value;
    }
}
