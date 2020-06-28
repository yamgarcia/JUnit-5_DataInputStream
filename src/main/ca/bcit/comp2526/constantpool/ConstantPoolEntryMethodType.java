package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryMethodType extends ConstantPoolEntry {
    private final static int SLOTS = 1;
    private int value;

    public ConstantPoolEntryMethodType(DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {
        this.value = StreamUtils.readUnsignedShort(stream);
        if (this.value == 0) throw new InvalidConstantPoolIndexException("descriptorIndex", this.value);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getDescriptorIndex() {
        return this.value;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.METHOD_TYPE;
    }

}
