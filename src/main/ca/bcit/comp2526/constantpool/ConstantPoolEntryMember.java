package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ConstantPoolEntryMember
    extends ConstantPoolEntry
{
    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantPoolEntryMember(final ConstantPoolType type,
                                   final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(type);


        classIndex = StreamUtils.readUnsignedShort(stream);


        if(classIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("classIndex", classIndex);
        }

        nameAndTypeIndex = StreamUtils.readUnsignedShort(stream);

        if(nameAndTypeIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("nameAndTypeIndex", nameAndTypeIndex);
        }
    }

    public int getClassIndex()
    {
        return classIndex;
    }

    public int getNameAndTypeIndex()
    {
        return nameAndTypeIndex;
    }
}
