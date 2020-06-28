package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.ClassFileException;
import ca.bcit.comp2526.NotEnoughDataException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class ConstantPoolEntryTest<T extends ConstantPoolEntry>
{
    protected T entryA;
    protected T entryB;

    protected abstract T createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException,
            ClassFileException;

    protected final T createInstance(final byte[] ... byteCollection)
            throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        try(final ByteArrayOutputStream stream = new ByteArrayOutputStream())
        {
            final byte[] bytes;
            final T entry;

            for(final byte[] array : byteCollection)
            {
                stream.writeBytes(array);
            }

            bytes = stream.toByteArray();
            entry = createInstance(bytes);

            return entry;
        }
    }

    protected final void testGetNumberOfSlots(final ConstantPoolEntry entry,
                                              final int               expected)
    {
        assertThat(entry.getNumberOfSlots(), equalTo(expected));
    }

    protected final void testGetType(final ConstantPoolEntry entry,
                                     final ConstantPoolType expected)
    {
        assertThat(entry.getType(), equalTo(expected));
    }

    protected final void testNotEnoughData(final int    expectedSize,
                                           final int    actualSize,
                                           final byte[] bytes)
    {
        final NotEnoughDataException ex;

        ex = assertThrows(NotEnoughDataException.class, () -> createInstance(bytes));
        assertThat(ex.getMessage(), equalTo(String.format("Require %d bytes to be available, have: %d", expectedSize, actualSize)));
    }
}
