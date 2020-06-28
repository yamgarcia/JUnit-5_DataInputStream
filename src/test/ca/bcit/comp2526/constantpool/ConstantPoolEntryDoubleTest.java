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
public class ConstantPoolEntryDoubleTest
        extends ConstantPoolEntryUnaryTest<ConstantPoolEntryDouble>
{
    public ConstantPoolEntryDoubleTest()
    {
        super(Double.BYTES);
    }

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException
    {
        entryA = createInstance(ByteUtils.doubleToBytes(Double.MAX_VALUE));
        entryB = createInstance(ByteUtils.doubleToBytes(Double.MIN_VALUE));
    }

    @Override
    protected ConstantPoolEntryDouble createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        final ConstantPoolEntryDouble entry;

        entry = new ConstantPoolEntryDouble(new DataInputStream(new ByteArrayInputStream(bytes)));

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
        testGetType(entryA, ConstantPoolType.DOUBLE);
        testGetType(entryB, ConstantPoolType.DOUBLE);
    }

    @Test
    public void testGetValue()
    {
        assertThat(entryA.getValue(), equalTo(Double.MAX_VALUE));
        assertThat(entryB.getValue(), equalTo(Double.MIN_VALUE));
    }
}