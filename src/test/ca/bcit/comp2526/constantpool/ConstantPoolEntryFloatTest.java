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
public class ConstantPoolEntryFloatTest
        extends ConstantPoolEntryUnaryTest<ConstantPoolEntryFloat>
{
    public ConstantPoolEntryFloatTest()
    {
        super(Float.BYTES);
    }

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException
    {
        entryA = createInstance(ByteUtils.floatToBytes(Float.MAX_VALUE));
        entryB = createInstance(ByteUtils.floatToBytes(Float.MIN_VALUE));
    }

    @Override
    protected ConstantPoolEntryFloat createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        final ConstantPoolEntryFloat entry;

        entry = new ConstantPoolEntryFloat(new DataInputStream(new ByteArrayInputStream(bytes)));

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
        testGetType(entryA, ConstantPoolType.FLOAT);
        testGetType(entryB, ConstantPoolType.FLOAT);
    }

    @Test
    public void testGetValue()
    {
        assertThat(entryA.getValue(), equalTo(Float.MAX_VALUE));
        assertThat(entryB.getValue(), equalTo(Float.MIN_VALUE));
    }
}