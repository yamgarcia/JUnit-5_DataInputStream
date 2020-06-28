package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.ByteUtils;
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
public class ConstantPoolEntryIntegerTest
        extends ConstantPoolEntryUnaryTest<ConstantPoolEntryInteger>
{
    public ConstantPoolEntryIntegerTest()
    {
        super(Integer.BYTES);
    }

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException
    {
        entryA = createInstance(ByteUtils.intToBytes(Integer.MAX_VALUE));
        entryB = createInstance(ByteUtils.intToBytes(Integer.MIN_VALUE));
    }

    @Override
    protected ConstantPoolEntryInteger createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        final ConstantPoolEntryInteger entry;

        entry = new ConstantPoolEntryInteger(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(new byte[] {});
        testNotEnoughData(new byte[] { 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00 });
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
        testGetType(entryA, ConstantPoolType.INTEGER);
        testGetType(entryB, ConstantPoolType.INTEGER);
    }

    @Test
    public void testGetValue()
    {
        assertThat(entryA.getValue(), equalTo(Integer.MAX_VALUE));
        assertThat(entryB.getValue(), equalTo(Integer.MIN_VALUE));
    }
}