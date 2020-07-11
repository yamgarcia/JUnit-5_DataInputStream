package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryInteger
        extends ConstantPoolEntryPrimitive<Integer>
{
    public ConstantPoolEntryInteger(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException
    {
        super(ConstantPoolType.INTEGER, 1, stream, StreamUtils::readInt);
    }
}

