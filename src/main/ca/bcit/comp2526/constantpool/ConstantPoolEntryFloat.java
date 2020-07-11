package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryFloat
        extends ConstantPoolEntryPrimitive<Float>
{
    public ConstantPoolEntryFloat(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException
    {
        super(ConstantPoolType.FLOAT, 1, stream, StreamUtils::readFloat);
    }
}

