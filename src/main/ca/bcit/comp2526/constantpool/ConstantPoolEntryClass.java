package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryClass
    extends ConstantPoolEntry
{
    private final int nameIndex;

    public ConstantPoolEntryClass(final DataInputStream stream)
        throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.CLASS);

        nameIndex = StreamUtils.readUnsignedShort(stream);

        if(nameIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("nameIndex", nameIndex);
        }
    }

    public int getNameIndex()
    {
        return nameIndex;
    }
}
