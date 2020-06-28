package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryField extends ConstantPoolEntry {
    private final static int SLOTS = 1;
    private int value1;
    private int value2;

    public ConstantPoolEntryField(DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {

        this.value1 = StreamUtils.readShort(stream);
        if (this.value1 == 0) throw new InvalidConstantPoolIndexException("classIndex", this.value1);
        this.value2 = StreamUtils.readShort(stream);
        if (this.value2 == 0) throw new InvalidConstantPoolIndexException("nameAndTypeIndex", this.value2);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getClassIndex() {
        return this.value1;
    }

    public int getNameAndTypeIndex() {
        return this.value1 == 1 ? 2 : 1;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.FIELD;
    }
}
