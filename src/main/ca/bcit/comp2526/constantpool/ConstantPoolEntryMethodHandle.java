package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryMethodHandle extends ConstantPoolEntry {

    private final static int SLOTS = 1;
    private short value1;
    private int value2;
    private MethodHandleKind value3;

    public ConstantPoolEntryMethodHandle(DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {
        if (stream == null) throw new InvalidReferenceKindException(StreamUtils.readUnsignedByte(stream));

        this.value1 = StreamUtils.readUnsignedByte(stream);
        if (this.value1 == 0) throw new InvalidReferenceKindException(this.value1);
        this.value2 = StreamUtils.readUnsignedShort(stream);
        if (this.value2 == 0) throw new InvalidConstantPoolIndexException("referenceIndex", this.value2); //l

        this.value3 = MethodHandleKind.fromType(value1);
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }

    public int getReferenceIndex() {
        return this.value2;
    }

    public MethodHandleKind getReferenceKind() {
        return value3;
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.METHOD_HANDLE;
    }
}