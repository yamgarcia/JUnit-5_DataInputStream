package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryPackage extends ConstantPoolEntry {
    private int value;
    private final static int SLOTS = 1;


    public ConstantPoolEntryPackage(DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {
        this.value = StreamUtils.readUnsignedShort(stream);
        if (this.value == 0) throw new InvalidConstantPoolIndexException(this.value);
    }
    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getNameIndex() {
        return this.value;
    }


    public ConstantPoolType getType() {
        return ConstantPoolType.PACKAGE;
    }
}
