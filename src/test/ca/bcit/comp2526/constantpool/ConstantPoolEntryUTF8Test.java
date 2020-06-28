package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.ByteUtils;
import ca.bcit.comp2526.ClassFileException;
import ca.bcit.comp2526.NotEnoughDataException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantPoolEntryUTF8Test
    extends ConstantPoolEntryTest<ConstantPoolEntryUTF8>
{
    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        entryA = createInstance("Hello");
        entryB = createInstance("Hello, World!");
    }

    private ConstantPoolEntryUTF8 createInstance(final String value)
        throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        final byte[] bytes;
        final ConstantPoolEntryUTF8 entry;

        bytes = ByteUtils.stringToBytes(value);
        entry = createInstance(ByteUtils.unsignedShortToBytes(bytes.length), bytes);

        return entry;
    }

    @Override
    protected ConstantPoolEntryUTF8 createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        final ConstantPoolEntryUTF8 entry;

        entry = new ConstantPoolEntryUTF8(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(2, 0, new byte[] {});
        testNotEnoughData(2, 1, new byte[] { 0x00 });
        testNotEnoughData(1, 0, new byte[] { 0x00, 0x01 });
        testNotEnoughData(2, 1, new byte[] { 0x00, 0x02, 0x02 });
        testNotEnoughData(3, 2, new byte[] { 0x00, 0x03, 0x02, 0x01 });
    }

    @Test
    public void testGetNumberOfSlots()
    {
        testGetNumberOfSlots(entryA, 1);
        testGetNumberOfSlots(entryB, 1);
    }

    @Test
    public void testGetType()
    {
        testGetType(entryA, ConstantPoolType.UTF8);
        testGetType(entryB, ConstantPoolType.UTF8);
    }

    @Test
    public void getGetBytes()
    {
        assertThat(entryA.getBytes(), equalTo("Hello".getBytes()));
        assertThat(entryB.getBytes(), equalTo("Hello, World!".getBytes()));
    }

    @Test
    public void testGetString()
    {
        assertThat(entryA.getString(), equalTo("Hello"));
        assertThat(entryB.getString(), equalTo("Hello, World!"));
    }
}