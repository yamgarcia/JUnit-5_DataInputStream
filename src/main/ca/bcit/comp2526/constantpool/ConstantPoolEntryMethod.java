package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryMethod
    extends ConstantPoolEntryMember
{
    public ConstantPoolEntryMethod(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.METHOD, stream);
    }
}
