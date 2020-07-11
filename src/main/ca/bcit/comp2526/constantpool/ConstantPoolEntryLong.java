package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryLong
        extends ConstantPoolEntryPrimitive<Long>
{
    public ConstantPoolEntryLong(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException
    {
        super(ConstantPoolType.LONG, 2, stream, StreamUtils::readLong);
    }
}

