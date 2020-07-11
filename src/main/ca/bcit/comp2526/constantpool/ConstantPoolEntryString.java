package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryString
        extends ConstantPoolEntry
{
    private final int stringIndex;

    public ConstantPoolEntryString(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.STRING);

        stringIndex = StreamUtils.readUnsignedShort(stream);

        if(stringIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("stringIndex", stringIndex);
        }
    }

    public int getStringIndex()
    {
        return stringIndex;
    }
}

