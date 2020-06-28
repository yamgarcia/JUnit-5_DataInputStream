package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryString extends ConstantPoolEntry {

    private int value;
    private final static int SLOTS = 1;

    public ConstantPoolEntryString(DataInputStream stream)
            throws IOException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException {
        this.value = StreamUtils.readUnsignedShort(stream);
        if (this.value == 0) throw new InvalidConstantPoolIndexException(this.value);
    }
    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getStringIndex() {
        return value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.STRING;
    }
}
