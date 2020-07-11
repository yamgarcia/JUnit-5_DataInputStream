package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryAbstractDynamic
    extends ConstantPoolEntry
{
    private final int bootstrapMethodAttrIndex;
    private final int nameAndTypeIndex;

    public ConstantPoolEntryAbstractDynamic(final ConstantPoolType type,
                                            final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(type);

        bootstrapMethodAttrIndex = StreamUtils.readUnsignedShort(stream);

        if(bootstrapMethodAttrIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("bootstrapMethodAttrIndex", bootstrapMethodAttrIndex);
        }

        nameAndTypeIndex = StreamUtils.readUnsignedShort(stream);

        if(nameAndTypeIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("nameAndTypeIndex", nameAndTypeIndex);
        }
    }

    public int getBootstrapMethodAttrIndex()
    {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex()
    {
        return nameAndTypeIndex;
    }
}
