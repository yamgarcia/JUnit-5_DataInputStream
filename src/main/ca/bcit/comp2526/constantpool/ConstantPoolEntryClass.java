package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.*;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryClass
        extends ConstantPoolEntry {

    private final static int SLOTS = 1;
    private final int value;

    public ConstantPoolEntryClass(DataInputStream stream)
            throws NotEnoughDataException,
            IOException,
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
        return ConstantPoolType.CLASS;
    }

}
