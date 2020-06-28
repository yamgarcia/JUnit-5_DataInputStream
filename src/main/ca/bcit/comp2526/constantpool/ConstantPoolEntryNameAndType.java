package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryNameAndType extends ConstantPoolEntry {
    private final static int SLOTS = 1;
    private int value1;
    private int value2;


    public ConstantPoolEntryNameAndType(DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {
        this.value1 = StreamUtils.readUnsignedShort(stream);
        if (this.value1 == 0) throw new InvalidConstantPoolIndexException("nameIndex", this.value1);
        this.value2 = StreamUtils.readUnsignedShort(stream);
        if (this.value2 == 0) throw new InvalidConstantPoolIndexException("descriptorIndex", this.value2);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getNameIndex() {
        return this.value1;
    }

    public int getDescriptorIndex() {

        if (this.value1 == 1) return 2;
        else return 1;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.NAME_AND_TYPE;
    }
}
