package ca.bcit.comp2526;

import java.io.IOException;

public class InvalidMagicNumberException
        extends ClassFileException {
    private final long value;

    public InvalidMagicNumberException(final long value) {
        //3405691581
        super(String.format("Magic number must be 3405691582, was: %d", value));
        this.value = value;
    }

    public long getExpected() {
        return value;
    }
}
