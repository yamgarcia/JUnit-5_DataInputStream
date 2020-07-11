package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryInvokeDynamic
    extends ConstantPoolEntryAbstractDynamic
{
    public ConstantPoolEntryInvokeDynamic(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        super(ConstantPoolType.INVOKE_DYNAMIC, stream);
    }
}
