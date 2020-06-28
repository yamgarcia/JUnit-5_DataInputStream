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
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantPoolEntryPackageTest
    extends ConstantPoolEntryUnaryTest<ConstantPoolEntryPackage>
{
    public ConstantPoolEntryPackageTest()
    {
        super(Short.BYTES);
    }

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        entryA = createInstance(ByteUtils.unsignedShortToBytes(1));
        entryB = createInstance(ByteUtils.unsignedShortToBytes(2));
    }

    @Override
    protected ConstantPoolEntryPackage createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException
    {
        final ConstantPoolEntryPackage entry;

        entry = new ConstantPoolEntryPackage(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(new byte[] {});
        testNotEnoughData(new byte[] { 0x00 });
    }

    @Test
    public void testBadNameIndex()
    {
        final InvalidConstantPoolIndexException ex;

        ex = assertThrows(InvalidConstantPoolIndexException.class, () -> createInstance(ByteUtils.unsignedShortToBytes(0)));
        assertThat(ex.getMessage(), equalTo("nameIndex must be > 0, was: 0"));
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
        testGetType(entryA, ConstantPoolType.PACKAGE);
        testGetType(entryB, ConstantPoolType.PACKAGE);
    }

    @Test
    public void testGetNameIndex()
    {
        assertThat(entryA.getNameIndex(), equalTo(1));
        assertThat(entryB.getNameIndex(), equalTo(2));
    }
}