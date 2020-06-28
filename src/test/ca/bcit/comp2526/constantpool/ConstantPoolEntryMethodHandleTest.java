package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.*;
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
public class ConstantPoolEntryMethodHandleTest
    extends ConstantPoolEntryTest<ConstantPoolEntryMethodHandle>
{
    private ConstantPoolEntryMethodHandle entryC;
    private ConstantPoolEntryMethodHandle entryD;
    private ConstantPoolEntryMethodHandle entryE;
    private ConstantPoolEntryMethodHandle entryF;
    private ConstantPoolEntryMethodHandle entryG;
    private ConstantPoolEntryMethodHandle entryH;
    private ConstantPoolEntryMethodHandle entryI;

    @BeforeAll
    public void createInstances()
            throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        entryA = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.GET_FIELD.getType()), ByteUtils.unsignedShortToBytes(2));
        entryB = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.GET_STATIC.getType()), ByteUtils.unsignedShortToBytes(3));
        entryC = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.PUT_FIELD.getType()), ByteUtils.unsignedShortToBytes(3));
        entryD = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.PUT_STATIC.getType()), ByteUtils.unsignedShortToBytes(2));
        entryE = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.INVOKE_VIRTUAL.getType()), ByteUtils.unsignedShortToBytes(2));
        entryF = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.INVOKE_STATIC.getType()), ByteUtils.unsignedShortToBytes(3));
        entryG = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.INVOKE_SPECIAL.getType()), ByteUtils.unsignedShortToBytes(2));
        entryH = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.NEW_INVOKE_SPECIAL.getType()), ByteUtils.unsignedShortToBytes(3));
        entryI = createInstance(ByteUtils.unsignedByteToBytes(MethodHandleKind.INVOKE_INTERFACE.getType()), ByteUtils.unsignedShortToBytes(3));
    }

    @Override
    protected ConstantPoolEntryMethodHandle createInstance(final byte[] bytes)
            throws IOException,
            NotEnoughDataException,
            InvalidReferenceKindException,
            InvalidConstantPoolIndexException
    {
        final ConstantPoolEntryMethodHandle entry;

        entry = new ConstantPoolEntryMethodHandle(new DataInputStream(new ByteArrayInputStream(bytes)));

        return entry;
    }

    @Test
    public void testNotEnoughData()
    {
        testNotEnoughData(1, 0, new byte[] {});
        testNotEnoughData(2, 0, new byte[] { 0x01 });
        testNotEnoughData(2, 1, new byte[] { 0x01, 0x01 });
    }

    @Test
    public void testBadReferenceKind()
    {
        final InvalidReferenceKindException ex;

        ex = assertThrows(InvalidReferenceKindException.class, () -> createInstance(new byte[] { 0x00 }));
        assertThat(ex.getMessage(), equalTo("referenceKind must be between 1 and 9, was: 0"));
        assertThat(ex.getValue(), equalTo((short)0));
    }

    @Test
    public void testBadNameAndTypeIndex()
    {
        final InvalidConstantPoolIndexException ex;

        ex = assertThrows(InvalidConstantPoolIndexException.class, () -> createInstance(ByteUtils.unsignedByteToBytes(1), ByteUtils.unsignedShortToBytes(0)));
        assertThat(ex.getMessage(), equalTo("referenceIndex must be > 0, was: 0"));
        assertThat(ex.getIndex(), equalTo(0));
    }

    @Test
    public void testGetNumberOfSlots()
    {
        testGetNumberOfSlots(entryA, 1);
        testGetNumberOfSlots(entryB, 1);
        testGetNumberOfSlots(entryC, 1);
        testGetNumberOfSlots(entryD, 1);
        testGetNumberOfSlots(entryE, 1);
        testGetNumberOfSlots(entryF, 1);
        testGetNumberOfSlots(entryG, 1);
        testGetNumberOfSlots(entryH, 1);
        testGetNumberOfSlots(entryI, 1);
    }

    @Test
    public void testGetType()
    {
        testGetType(entryA, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryB, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryC, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryD, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryE, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryF, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryG, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryH, ConstantPoolType.METHOD_HANDLE);
        testGetType(entryI, ConstantPoolType.METHOD_HANDLE);
    }

    @Test
    public void testGetReferenceKind()
    {
        assertThat(entryA.getReferenceKind(), equalTo(MethodHandleKind.GET_FIELD));
        assertThat(entryB.getReferenceKind(), equalTo(MethodHandleKind.GET_STATIC));
        assertThat(entryC.getReferenceKind(), equalTo(MethodHandleKind.PUT_FIELD));
        assertThat(entryD.getReferenceKind(), equalTo(MethodHandleKind.PUT_STATIC));
        assertThat(entryE.getReferenceKind(), equalTo(MethodHandleKind.INVOKE_VIRTUAL));
        assertThat(entryF.getReferenceKind(), equalTo(MethodHandleKind.INVOKE_STATIC));
        assertThat(entryG.getReferenceKind(), equalTo(MethodHandleKind.INVOKE_SPECIAL));
        assertThat(entryH.getReferenceKind(), equalTo(MethodHandleKind.NEW_INVOKE_SPECIAL));
        assertThat(entryI.getReferenceKind(), equalTo(MethodHandleKind.INVOKE_INTERFACE));
    }

    @Test
    public void testGetReferenceIndex()
    {
        assertThat(entryA.getReferenceIndex(), equalTo(2));
        assertThat(entryB.getReferenceIndex(), equalTo(3));
        assertThat(entryC.getReferenceIndex(), equalTo(3));
        assertThat(entryD.getReferenceIndex(), equalTo(2));
        assertThat(entryE.getReferenceIndex(), equalTo(2));
        assertThat(entryF.getReferenceIndex(), equalTo(3));
        assertThat(entryG.getReferenceIndex(), equalTo(2));
        assertThat(entryH.getReferenceIndex(), equalTo(3));
        assertThat(entryI.getReferenceIndex(), equalTo(3));
    }
}