package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.InvalidReferenceKindException;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryMethodHandle
        extends ConstantPoolEntry
{
    private final MethodHandleKind kind;
    private final int referenceIndex;

    public ConstantPoolEntryMethodHandle(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidReferenceKindException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.METHOD_HANDLE);

        final short type;

        type = StreamUtils.readUnsignedByte(stream);
        kind = MethodHandleKind.fromType(type);
        referenceIndex = StreamUtils.readUnsignedShort(stream);

        if(referenceIndex == 0)
        {
            throw new InvalidConstantPoolIndexException("referenceIndex", referenceIndex);
        }
    }

    public MethodHandleKind getReferenceKind()
    {
        return kind;
    }

    public int getReferenceIndex()
    {
        return referenceIndex;
    }
}

