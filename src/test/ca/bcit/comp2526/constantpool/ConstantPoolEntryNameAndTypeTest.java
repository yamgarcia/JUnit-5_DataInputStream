package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.ByteUtils;
import ca.bcit.comp2526.ClassFileException;
import ca.bcit.comp2526.InvalidConstantPoolIndexException;
import ca.bcit.comp2526.NotEnoughDataException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantPoolEntryNameAndTypeTest
    extends ConstantPoolEntryTest<ConstantPoolEntryNameAndType>
{
    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        entryA = createInstance(ByteUtils.unsignedShortToBytes(1), ByteUtils.unsignedShortToBytes(2));
        entryB = createInstance(ByteUtils.unsignedShortToBytes(2), ByteUtils.unsignedShortToBytes(1));
    }

    @Override
    protected ConstantPoolEntryNameAndType createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        final ConstantPoolEntryNameAndType entry;

        entry = new ConstantPoolEntryNameAndType(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(2, 0, new byte[] {});
        testNotEnoughData(2, 1, new byte[] { 0x00 });
        testNotEnoughData(2, 0, new byte[] { 0x00, 0x01 });
        testNotEnoughData(2, 1, new byte[] { 0x00, 0x01, 0x02 });
    }

    @Test
    public void testBadClassIndex()
    {
        final InvalidConstantPoolIndexException ex;

        ex = assertThrows(InvalidConstantPoolIndexException.class, () -> createInstance(ByteUtils.unsignedShortToBytes(0), ByteUtils.unsignedShortToBytes(1)));
        assertThat(ex.getMessage(), equalTo("nameIndex must be > 0, was: 0"));
        assertThat(ex.getIndex(), equalTo(0));
    }

    @Test
    public void testBadDescriptorIndex()
    {
        final InvalidConstantPoolIndexException ex;

        ex = assertThrows(InvalidConstantPoolIndexException.class, () -> createInstance(ByteUtils.unsignedShortToBytes(1), ByteUtils.unsignedShortToBytes(0)));
        assertThat(ex.getMessage(), equalTo("descriptorIndex must be > 0, was: 0"));
        assertThat(ex.getIndex(), equalTo(0));
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
        testGetType(entryA, ConstantPoolType.NAME_AND_TYPE);
        testGetType(entryB, ConstantPoolType.NAME_AND_TYPE);
    }

    @Test
    public void testGetNameIndex()
    {
        assertThat(entryA.getNameIndex(), equalTo(1));
        assertThat(entryB.getNameIndex(), equalTo(2));
    }

    @Test
    public void testGetDescriptorIndex()
    {
        assertThat(entryA.getDescriptorIndex(), equalTo(2));
        assertThat(entryB.getDescriptorIndex(), equalTo(1));
    }
}