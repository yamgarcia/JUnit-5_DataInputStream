package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantPoolTest
{
    private ConstantPool poolA;
    private ConstantPool poolB;

    @BeforeAll
    public void createClassFile()
        throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException,
            InvalidReferenceKindException,
            InvalidConstantPoolTagException
    {
        final ConstantPoolEntryFactory factory;

        factory = new DefaultConstantPoolEntryFactory();
        poolA = createConstantPool(factory, new byte[] { (byte)0x00, (byte)0x11, (byte)0x0A, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x0E, (byte)0x07, (byte)0x00, (byte)0x0F, (byte)0x07, (byte)0x00, (byte)0x10, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x3C, (byte)0x69, (byte)0x6E, (byte)0x69, (byte)0x74, (byte)0x3E, (byte)0x01, (byte)0x00, (byte)0x03, (byte)0x28, (byte)0x29, (byte)0x56, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x43, (byte)0x6F, (byte)0x64, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0F, (byte)0x4C, (byte)0x69, (byte)0x6E, (byte)0x65, (byte)0x4E, (byte)0x75, (byte)0x6D, (byte)0x62, (byte)0x65, (byte)0x72, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x12, (byte)0x4C, (byte)0x6F, (byte)0x63, (byte)0x61, (byte)0x6C, (byte)0x56, (byte)0x61, (byte)0x72, (byte)0x69, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x74, (byte)0x68, (byte)0x69, (byte)0x73, (byte)0x01, (byte)0x00, (byte)0x2A, (byte)0x4C, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x41, (byte)0x62, (byte)0x73, (byte)0x74, (byte)0x72, (byte)0x61, (byte)0x63, (byte)0x74, (byte)0x43, (byte)0x6C, (byte)0x61, (byte)0x73, (byte)0x73, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4D, (byte)0x65, (byte)0x74, (byte)0x68, (byte)0x6F, (byte)0x64, (byte)0x3B, (byte)0x01, (byte)0x00, (byte)0x03, (byte)0x66, (byte)0x6F, (byte)0x6F, (byte)0x01, (byte)0x00, (byte)0x0A, (byte)0x53, (byte)0x6F, (byte)0x75, (byte)0x72, (byte)0x63, (byte)0x65, (byte)0x46, (byte)0x69, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x1C, (byte)0x41, (byte)0x62, (byte)0x73, (byte)0x74, (byte)0x72, (byte)0x61, (byte)0x63, (byte)0x74, (byte)0x43, (byte)0x6C, (byte)0x61, (byte)0x73, (byte)0x73, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4D, (byte)0x65, (byte)0x74, (byte)0x68, (byte)0x6F, (byte)0x64, (byte)0x2E, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x0C, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x01, (byte)0x00, (byte)0x28, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x41, (byte)0x62, (byte)0x73, (byte)0x74, (byte)0x72, (byte)0x61, (byte)0x63, (byte)0x74, (byte)0x43, (byte)0x6C, (byte)0x61, (byte)0x73, (byte)0x73, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4D, (byte)0x65, (byte)0x74, (byte)0x68, (byte)0x6F, (byte)0x64, (byte)0x01, (byte)0x00, (byte)0x10, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2F, (byte)0x6C, (byte)0x61, (byte)0x6E, (byte)0x67, (byte)0x2F, (byte)0x4F, (byte)0x62, (byte)0x6A, (byte)0x65, (byte)0x63, (byte)0x74, (byte)0x04, (byte)0x21, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x2F, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x05, (byte)0x2A, (byte)0xB7, (byte)0x00, (byte)0x01, (byte)0xB1, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0B, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x2B, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0xB1, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x0D });
        poolB = createConstantPool(factory, new byte[] { (byte)0x00, (byte)0x16, (byte)0x0A, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x12, (byte)0x05, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0D, (byte)0x09, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x13, (byte)0x07, (byte)0x00, (byte)0x14, (byte)0x07, (byte)0x00, (byte)0x15, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x78, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x4A, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x3C, (byte)0x69, (byte)0x6E, (byte)0x69, (byte)0x74, (byte)0x3E, (byte)0x01, (byte)0x00, (byte)0x03, (byte)0x28, (byte)0x29, (byte)0x56, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x43, (byte)0x6F, (byte)0x64, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0F, (byte)0x4C, (byte)0x69, (byte)0x6E, (byte)0x65, (byte)0x4E, (byte)0x75, (byte)0x6D, (byte)0x62, (byte)0x65, (byte)0x72, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x12, (byte)0x4C, (byte)0x6F, (byte)0x63, (byte)0x61, (byte)0x6C, (byte)0x56, (byte)0x61, (byte)0x72, (byte)0x69, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x74, (byte)0x68, (byte)0x69, (byte)0x73, (byte)0x01, (byte)0x00, (byte)0x1B, (byte)0x4C, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4C, (byte)0x6F, (byte)0x6E, (byte)0x67, (byte)0x3B, (byte)0x01, (byte)0x00, (byte)0x0A, (byte)0x53, (byte)0x6F, (byte)0x75, (byte)0x72, (byte)0x63, (byte)0x65, (byte)0x46, (byte)0x69, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0D, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4C, (byte)0x6F, (byte)0x6E, (byte)0x67, (byte)0x2E, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x0C, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x0A, (byte)0x0C, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x08, (byte)0x01, (byte)0x00, (byte)0x19, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x4C, (byte)0x6F, (byte)0x6E, (byte)0x67, (byte)0x01, (byte)0x00, (byte)0x10, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2F, (byte)0x6C, (byte)0x61, (byte)0x6E, (byte)0x67, (byte)0x2F, (byte)0x4F, (byte)0x62, (byte)0x6A, (byte)0x65, (byte)0x63, (byte)0x74, (byte)0x00, (byte)0x21, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0B, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x3A, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x2A, (byte)0xB7, (byte)0x00, (byte)0x01, (byte)0x2A, (byte)0x14, (byte)0x00, (byte)0x02, (byte)0xB5, (byte)0x00, (byte)0x04, (byte)0xB1, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x0D, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x0E, (byte)0x00, (byte)0x0F, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x10, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x11 });
    }

    protected ConstantPool createConstantPool(final ConstantPoolEntryFactory factory,
                                              final byte[] bytes)
        throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException,
            InvalidReferenceKindException,
            InvalidConstantPoolTagException
    {
        try(final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes)))
        {
            final ConstantPool constantPool;

            constantPool = new ConstantPool(factory, stream);

            return constantPool;
        }
    }

    @Test
    public void testGetCount()
    {
        assertThat(poolA.getNumberOfEntries(), equalTo(16));
        assertThat(poolB.getNumberOfEntries(), equalTo(21));
    }

    /**
     * package ca.bcit.comp2526;
     *
     * public abstract class AbstractClassWithMethod
     * {
     *     public void foo()
     *     {
     *     }
     * }
     */
    @Test
    public void testPoolA()
    {
        testEntryNull(poolA, 0, null);
        testEntryMethod(poolA, 1, 3, 14);
        testEntryClass(poolA, 2, 15);
        testEntryClass(poolA, 3, 16);
        testEntryUTF8(poolA, 4, "<init>");
        testEntryUTF8(poolA, 5, "()V");
        testEntryUTF8(poolA, 6, "Code");
        testEntryUTF8(poolA, 7, "LineNumberTable");
        testEntryUTF8(poolA, 8, "LocalVariableTable");
        testEntryUTF8(poolA, 9, "this");
        testEntryUTF8(poolA, 10, "Lca/bcit/comp2526/AbstractClassWithMethod;");
        testEntryUTF8(poolA, 11, "foo");
        testEntryUTF8(poolA, 12, "SourceFile");
        testEntryUTF8(poolA, 13, "AbstractClassWithMethod.java");
        testEntryNameAndType(poolA, 14, 4, 5);
        testEntryUTF8(poolA, 15, "ca/bcit/comp2526/AbstractClassWithMethod");
        testEntryUTF8(poolA, 16, "java/lang/Object");
    }

    /**
     * public class WithLong
     * {
     *     private long x = 13L;
     * }
     */
    @Test
    public void testPoolB()
    {
        testEntryNull(poolB, 0, null);
        testEntryMethod(poolB, 1, 6, 18);
        testEntryLong(poolB, 2, 13L);
        testEntryNull(poolB, 3, null);
        testEntryField(poolB, 4, 5, 19);
        testEntryClass(poolB, 5, 20);
        testEntryClass(poolB, 6, 21);
        testEntryUTF8(poolB, 7, "x");
        testEntryUTF8(poolB, 8, "J");
        testEntryUTF8(poolB, 9, "<init>");
        testEntryUTF8(poolB, 10, "()V");
        testEntryUTF8(poolB, 11, "Code");
        testEntryUTF8(poolB, 12, "LineNumberTable");
        testEntryUTF8(poolB, 13, "LocalVariableTable");
        testEntryUTF8(poolB, 14, "this");
        testEntryUTF8(poolB, 15, "Lca/bcit/comp2526/WithLong;");
        testEntryUTF8(poolB, 16, "SourceFile");
        testEntryUTF8(poolB, 17, "WithLong.java");
        testEntryNameAndType(poolB, 18, 9, 10);
        testEntryNameAndType(poolB, 19, 7, 8);
        testEntryUTF8(poolB, 20, "ca/bcit/comp2526/WithLong");
        testEntryUTF8(poolB, 21, "java/lang/Object");
    }

    private void testEntryNull(final ConstantPool pool,
                               final int          index,
                               final Class<? extends ConstantPoolEntry> expected)
    {
        final ConstantPoolEntry entry;

        entry = pool.getEntry(index);
        assertThat(entry, nullValue());
    }

    private <T extends ConstantPoolEntry> T testEntry(final ConstantPool pool,
                                                      final int          index,
                                                      final Class<T>     expected)
    {
        final ConstantPoolEntry entry;

        entry = pool.getEntry(index);
        assertThat(entry, instanceOf(expected));

        return (T)entry;
    }

    private void testEntryMethod(final ConstantPool pool,
                                 final int          index,
                                 final int          classIndex,
                                 final int          nameAndTypeIndex)
    {
        final ConstantPoolEntryMethod entry;

        entry = testEntry(pool, index, ConstantPoolEntryMethod.class);
        assertThat(entry.getClassIndex(), equalTo(classIndex));
        assertThat(entry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    private void testEntryClass(final ConstantPool pool,
                                final int          index,
                                final int          nameIndex)
    {
        final ConstantPoolEntryClass entry;

        entry = testEntry(pool, index, ConstantPoolEntryClass.class);
        assertThat(entry.getNameIndex(), equalTo(nameIndex));
    }

    private void testEntryUTF8(final ConstantPool pool,
                               final int          index,
                               final String       string)
    {
        final ConstantPoolEntryUTF8 entry;

        entry = testEntry(pool, index, ConstantPoolEntryUTF8.class);
        assertThat(entry.getString(), equalTo(string));
        assertThat(entry.getBytes(), equalTo(string.getBytes()));
    }

    private void testEntryNameAndType(final ConstantPool pool,
                                      final int          index,
                                      final int          nameIndex,
                                      final int          descriptorIndex)
    {
        final ConstantPoolEntryNameAndType entry;

        entry = testEntry(pool, index, ConstantPoolEntryNameAndType.class);
        assertThat(entry.getNameIndex(), equalTo(nameIndex));
        assertThat(entry.getDescriptorIndex(), equalTo(descriptorIndex));
    }

    private void testEntryLong(final ConstantPool pool,
                               final int          index,
                               final long         value)
    {
        final ConstantPoolEntryLong entry;

        entry = testEntry(pool, index, ConstantPoolEntryLong.class);
        assertThat(entry.getValue(), equalTo(value));
    }
    private void testEntryField(final ConstantPool pool,
                                final int          index,
                                final int          classIndex,
                                final int          nameAndTypeIndex)
    {
        final ConstantPoolEntryField entry;

        entry = testEntry(pool, index, ConstantPoolEntryField.class);
        assertThat(entry.getClassIndex(), equalTo(classIndex));
        assertThat(entry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }
}
