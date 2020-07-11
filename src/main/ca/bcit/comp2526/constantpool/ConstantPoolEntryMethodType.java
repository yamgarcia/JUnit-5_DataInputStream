package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryMethodType
        extends ConstantPoolEntry
{
    private final int descriptorIndex;

    public ConstantPoolEntryMethodType(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.METHOD_TYPE);

        descriptorIndex = StreamUtils.readUnsignedShort(stream);

        if(descriptorIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("descriptorIndex", descriptorIndex);
        }
    }

    public int getDescriptorIndex()
    {
        return descriptorIndex;
    }
}

