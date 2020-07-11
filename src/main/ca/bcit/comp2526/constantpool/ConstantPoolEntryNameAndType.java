package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryNameAndType
        extends ConstantPoolEntry
{
    private final int nameIndex;
    private final int descriptorIndex;

    public ConstantPoolEntryNameAndType(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.NAME_AND_TYPE);

        nameIndex = StreamUtils.readUnsignedShort(stream);

        if(nameIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("nameIndex", nameIndex);
        }

        descriptorIndex = StreamUtils.readUnsignedShort(stream);

        if(descriptorIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("descriptorIndex", descriptorIndex);
        }
    }

    public int getNameIndex()
    {
        return nameIndex;
    }

    public int getDescriptorIndex()
    {
        return descriptorIndex;
    }

}
