package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryField
    extends ConstantPoolEntryMember
{
    public ConstantPoolEntryField(final DataInputStream stream)
        throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.FIELD, stream);
    }
}
