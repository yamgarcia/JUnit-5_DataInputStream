package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryInteger
        extends ConstantPoolEntry {

    private int value;

    public ConstantPoolEntryInteger(DataInputStream stream)
            throws IOException,
            NotEnoughDataException {
        this.value = StreamUtils.readInt(stream);
    }

    public int getNumberOfSlots() {
        return 1;
    }

    public Number getValue() {
        return this.value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.INTEGER;
    }
}
