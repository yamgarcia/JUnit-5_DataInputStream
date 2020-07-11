package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class ConstantPoolEntryPrimitive<T extends Number>
    extends ConstantPoolEntry
{
    interface Filter<T extends Number>
    {
        T apply(DataInputStream stream)
            throws IOException, NotEnoughDataException;
    }

    private final T value;

    public ConstantPoolEntryPrimitive(final ConstantPoolType type,
                                      final int slots,
                                      final DataInputStream stream,
                                      final Filter<T> filter)
        throws IOException,
            NotEnoughDataException
    {
        super(type, slots);

        value = filter.apply(stream);
    }

    public final T getValue()
    {
        return value;
    }
}
