package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryDouble
        extends ConstantPoolEntryPrimitive<Double>
{
    public ConstantPoolEntryDouble(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        super(ConstantPoolType.DOUBLE, 2, stream, StreamUtils::readDouble);
    }
}

