package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefaultConstantPoolEntryFactoryTest
{
    private DefaultConstantPoolEntryFactory factory;

    @BeforeAll
    public void setup()
    {
        factory = new DefaultConstantPoolEntryFactory();
    }

    @Test
    public void testCreateConstantPoolEntryClass()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryClass specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.CLASS,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.CLASS)));
        assertThat(entry, instanceOf(ConstantPoolEntryClass.class));
        specificEntry = (ConstantPoolEntryClass)entry;
        assertThat(specificEntry.getNameIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryDouble()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryDouble specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.DOUBLE,
                ByteUtils.createStream(ByteUtils.doubleToBytes(123.456)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.DOUBLE)));
        assertThat(entry, instanceOf(ConstantPoolEntryDouble.class));
        specificEntry = (ConstantPoolEntryDouble)entry;
        assertThat(specificEntry.getValue(), equalTo(123.456));
    }

    @Test
    public void testCreateConstantPoolEntryDynamic()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryDynamic specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.DYNAMIC,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(1), ByteUtils.unsignedShortToBytes(2)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.DYNAMIC)));
        assertThat(entry, instanceOf(ConstantPoolEntryDynamic.class));
        specificEntry = (ConstantPoolEntryDynamic)entry;
        assertThat(specificEntry.getBootstrapMethodAttrIndex(), equalTo(1));
        assertThat(specificEntry.getNameAndTypeIndex(), equalTo(2));
    }

    @Test
    public void testCreateConstantPoolEntryField()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryField specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.FIELD,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(2), ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.FIELD)));
        assertThat(entry, instanceOf(ConstantPoolEntryField.class));
        specificEntry = (ConstantPoolEntryField)entry;
        assertThat(specificEntry.getClassIndex(), equalTo(2));
        assertThat(specificEntry.getNameAndTypeIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryFloat()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryFloat specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.FLOAT,
                ByteUtils.createStream(ByteUtils.floatToBytes(234.567f)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.FLOAT)));
        assertThat(entry, instanceOf(ConstantPoolEntryFloat.class));
        specificEntry = (ConstantPoolEntryFloat)entry;
        assertThat(specificEntry.getValue(), equalTo(234.567f));
    }

    @Test
    public void testCreateConstantPoolEntryInteger()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryInteger specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.INTEGER,
                ByteUtils.createStream(ByteUtils.intToBytes(12)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.INTEGER)));
        assertThat(entry, instanceOf(ConstantPoolEntryInteger.class));
        specificEntry = (ConstantPoolEntryInteger)entry;
        assertThat(specificEntry.getValue(), equalTo(12));
    }

    @Test
    public void testCreateConstantPoolEntryInterfaceMethod()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryInterfaceMethod specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.INTERFACE_METHOD,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(1), ByteUtils.unsignedShortToBytes(4)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.INTERFACE_METHOD)));
        assertThat(entry, instanceOf(ConstantPoolEntryInterfaceMethod.class));
        specificEntry = (ConstantPoolEntryInterfaceMethod)entry;
        assertThat(specificEntry.getClassIndex(), equalTo(1));
        assertThat(specificEntry.getNameAndTypeIndex(), equalTo(4));
    }

    @Test
    public void testCreateConstantPoolEntryInvokeDynamic()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryInvokeDynamic specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.INVOKE_DYNAMIC,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(2), ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.INVOKE_DYNAMIC)));
        assertThat(entry, instanceOf(ConstantPoolEntryInvokeDynamic.class));
        specificEntry = (ConstantPoolEntryInvokeDynamic)entry;
        assertThat(specificEntry.getBootstrapMethodAttrIndex(), equalTo(2));
        assertThat(specificEntry.getNameAndTypeIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryLong()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryLong specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.LONG,
                ByteUtils.createStream(ByteUtils.longToBytes(9998L)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.LONG)));
        assertThat(entry, instanceOf(ConstantPoolEntryLong.class));
        specificEntry = (ConstantPoolEntryLong)entry;
        assertThat(specificEntry.getValue(), equalTo(9998L));
    }

    @Test
    public void testCreateConstantPoolEntryMethodHandle()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryMethodHandle specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.METHOD_HANDLE,
                ByteUtils.createStream(ByteUtils.unsignedByteToBytes(MethodHandleKind.INVOKE_INTERFACE.getType()), ByteUtils.unsignedShortToBytes(1)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.METHOD_HANDLE)));
        assertThat(entry, instanceOf(ConstantPoolEntryMethodHandle.class));
        specificEntry = (ConstantPoolEntryMethodHandle)entry;
        assertThat(specificEntry.getReferenceKind(), equalTo(MethodHandleKind.INVOKE_INTERFACE));
        assertThat(specificEntry.getReferenceIndex(), equalTo(1));
    }

    @Test
    public void testCreateConstantPoolEntryMethod()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryMethod specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.METHOD,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(1), ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.METHOD)));
        assertThat(entry, instanceOf(ConstantPoolEntryMethod.class));
        specificEntry = (ConstantPoolEntryMethod)entry;
        assertThat(specificEntry.getClassIndex(), equalTo(1));
        assertThat(specificEntry.getNameAndTypeIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryMethodType()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryMethodType specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.METHOD_TYPE,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(2)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.METHOD_TYPE)));
        assertThat(entry, instanceOf(ConstantPoolEntryMethodType.class));
        specificEntry = (ConstantPoolEntryMethodType)entry;
        assertThat(specificEntry.getDescriptorIndex(), equalTo(2));
    }

    @Test
    public void testCreateConstantPoolEntryModule()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryModule specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.MODULE,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(1)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.MODULE)));
        assertThat(entry, instanceOf(ConstantPoolEntryModule.class));
        specificEntry = (ConstantPoolEntryModule)entry;
        assertThat(specificEntry.getNameIndex(), equalTo(1));
    }

    @Test
    public void testCreateConstantPoolEntryNameAndType()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryNameAndType specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.NAME_AND_TYPE,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(3), ByteUtils.unsignedShortToBytes(4)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.NAME_AND_TYPE)));
        assertThat(entry, instanceOf(ConstantPoolEntryNameAndType.class));
        specificEntry = (ConstantPoolEntryNameAndType)entry;
        assertThat(specificEntry.getNameIndex(), equalTo(3));
        assertThat(specificEntry.getDescriptorIndex(), equalTo(4));
    }

    @Test
    public void testCreateConstantPoolEntryPackage()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryPackage specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.PACKAGE,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.PACKAGE)));
        assertThat(entry, instanceOf(ConstantPoolEntryPackage.class));
        specificEntry = (ConstantPoolEntryPackage)entry;
        assertThat(specificEntry.getNameIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryString()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryString specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.STRING,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(3)));
        assertThat(entry.getType(), equalTo((ConstantPoolType.STRING)));
        assertThat(entry, instanceOf(ConstantPoolEntryString.class));
        specificEntry = (ConstantPoolEntryString)entry;
        assertThat(specificEntry.getStringIndex(), equalTo(3));
    }

    @Test
    public void testCreateConstantPoolEntryUTF8()
            throws InvalidReferenceKindException,
            InvalidConstantPoolIndexException,
            NotEnoughDataException,
            InvalidConstantPoolTagException,
            IOException
    {
        final ConstantPoolEntry entry;
        final ConstantPoolEntryUTF8 specificEntry;

        entry = factory.createConstantPoolEntry(ConstantPoolType.UTF8,
                ByteUtils.createStream(ByteUtils.unsignedShortToBytes(5), "World".getBytes()));
        assertThat(entry.getType(), equalTo((ConstantPoolType.UTF8)));
        assertThat(entry, instanceOf(ConstantPoolEntryUTF8.class));
        specificEntry = (ConstantPoolEntryUTF8)entry;
        assertThat(specificEntry.getBytes(), equalTo(new byte[] { 87, 111, 114, 108, 100 }));
        assertThat(specificEntry.getString(), equalTo("World"));
    }
}
