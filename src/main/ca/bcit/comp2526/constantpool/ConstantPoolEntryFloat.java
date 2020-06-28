package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryFloat
        extends ConstantPoolEntry {

    private float value;
    private final static int SLOTS = 1;

    public ConstantPoolEntryFloat(DataInputStream stream) throws IOException, NotEnoughDataException {
        this.value = StreamUtils.readFloat(stream);
    }
    public int getNumberOfSlots() {
        return SLOTS;
    }

    public Number getValue() {
        return this.value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.FLOAT;
    }
}
