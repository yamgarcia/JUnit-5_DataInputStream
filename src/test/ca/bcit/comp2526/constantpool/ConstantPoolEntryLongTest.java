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
public class ConstantPoolEntryLongTest
        extends ConstantPoolEntryUnaryTest<ConstantPoolEntryLong>
{
    public ConstantPoolEntryLongTest()
    {
        super(Long.BYTES);
    }

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException
    {
        entryA = createInstance(ByteUtils.longToBytes(Long.MAX_VALUE));
        entryB = createInstance(ByteUtils.longToBytes(Long.MIN_VALUE));
    }

    @Override
    protected ConstantPoolEntryLong createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        final ConstantPoolEntryLong entry;

        entry = new ConstantPoolEntryLong(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(new byte[] {});
        testNotEnoughData(new byte[] { 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
        testNotEnoughData(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
    }

    @Test
    public void testGetNumberOfSlots()
    {
        testGetNumberOfSlots(entryA, 2);
        testGetNumberOfSlots(entryB, 2);
    }

    @Test
    public void testGetType()
    {
        testGetType(entryA, ConstantPoolType.LONG);
        testGetType(entryB, ConstantPoolType.LONG);
    }

    @Test
    public void testGetValue()
    {
        assertThat(entryA.getValue(), equalTo(Long.MAX_VALUE));
        assertThat(entryB.getValue(), equalTo(Long.MIN_VALUE));
    }
}