package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryDouble
        extends ConstantPoolEntry {
    private final static int SLOTS = 2;
    private double value;

    public ConstantPoolEntryDouble(DataInputStream stream)
            throws IOException,
            NotEnoughDataException {
        this.value = StreamUtils.readDouble(stream);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public Number getValue() {
        return this.value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.DOUBLE;
    }
}
