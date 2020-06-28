package ca.bcit.comp2526;

public class InvalidMajorVersionException
        extends ClassFileException {
    private final int value;

    public InvalidMajorVersionException(final int value) {
        super(String.format("Major number must be between 45 and 55, was: %d", value));
        this.value = value;
    }

    public int getExpected() {
        return value;
    }
}
