package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryLong
        extends ConstantPoolEntry {

    private final static int SLOTS = 2;
    private long value;

    public ConstantPoolEntryLong(DataInputStream stream)
            throws IOException,
            NotEnoughDataException {
        this.value = StreamUtils.readLong(stream);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public Number getValue() {
        return this.value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.LONG;
    }
}
