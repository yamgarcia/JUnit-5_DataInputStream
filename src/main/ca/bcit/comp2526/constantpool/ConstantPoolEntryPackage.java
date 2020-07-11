package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryPackage
        extends ConstantPoolEntry {
    private final int nameIndex;

    public ConstantPoolEntryPackage(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException {
        super(ConstantPoolType.PACKAGE);

        nameIndex = StreamUtils.readUnsignedShort(stream);

        if (nameIndex == 0) {
            throw new InvalidConstantPoolIndexException("nameIndex", nameIndex);
        }
    }

    public int getNameIndex() {
        return nameIndex;
    }
}

