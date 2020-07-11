package ca.bcit.comp2526.classes;

import ca.bcit.comp2526.ClassFile;
import ca.bcit.comp2526.ClassFileException;
import ca.bcit.comp2526.ClassFileTest;
import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.constantpool.ConstantPoolEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WithStringTests
    extends ClassFileTest
{
    private ClassFile classFile;

    @BeforeAll
    public void createClassFile()
        throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        classFile = createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x37, (byte)0x00, (byte)0x16, (byte)0x0A, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x11, (byte)0x08, (byte)0x00, (byte)0x12, (byte)0x09, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x13, (byte)0x07, (byte)0x00, (byte)0x14, (byte)0x07, (byte)0x00, (byte)0x15, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x78, (byte)0x01, (byte)0x00, (byte)0x12, (byte)0x4C, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2F, (byte)0x6C, (byte)0x61, (byte)0x6E, (byte)0x67, (byte)0x2F, (byte)0x53, (byte)0x74, (byte)0x72, (byte)0x69, (byte)0x6E, (byte)0x67, (byte)0x3B, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x3C, (byte)0x69, (byte)0x6E, (byte)0x69, (byte)0x74, (byte)0x3E, (byte)0x01, (byte)0x00, (byte)0x03, (byte)0x28, (byte)0x29, (byte)0x56, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x43, (byte)0x6F, (byte)0x64, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0F, (byte)0x4C, (byte)0x69, (byte)0x6E, (byte)0x65, (byte)0x4E, (byte)0x75, (byte)0x6D, (byte)0x62, (byte)0x65, (byte)0x72, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x12, (byte)0x4C, (byte)0x6F, (byte)0x63, (byte)0x61, (byte)0x6C, (byte)0x56, (byte)0x61, (byte)0x72, (byte)0x69, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x54, (byte)0x61, (byte)0x62, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x04, (byte)0x74, (byte)0x68, (byte)0x69, (byte)0x73, (byte)0x01, (byte)0x00, (byte)0x1D, (byte)0x4C, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x53, (byte)0x74, (byte)0x72, (byte)0x69, (byte)0x6E, (byte)0x67, (byte)0x3B, (byte)0x01, (byte)0x00, (byte)0x0A, (byte)0x53, (byte)0x6F, (byte)0x75, (byte)0x72, (byte)0x63, (byte)0x65, (byte)0x46, (byte)0x69, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0F, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x53, (byte)0x74, (byte)0x72, (byte)0x69, (byte)0x6E, (byte)0x67, (byte)0x2E, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x0C, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x09, (byte)0x01, (byte)0x00, (byte)0x0D, (byte)0x48, (byte)0x65, (byte)0x6C, (byte)0x6C, (byte)0x6F, (byte)0x2C, (byte)0x20, (byte)0x57, (byte)0x6F, (byte)0x72, (byte)0x6C, (byte)0x64, (byte)0x21, (byte)0x0C, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x07, (byte)0x01, (byte)0x00, (byte)0x1B, (byte)0x63, (byte)0x61, (byte)0x2F, (byte)0x62, (byte)0x63, (byte)0x69, (byte)0x74, (byte)0x2F, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x70, (byte)0x32, (byte)0x35, (byte)0x32, (byte)0x36, (byte)0x2F, (byte)0x57, (byte)0x69, (byte)0x74, (byte)0x68, (byte)0x53, (byte)0x74, (byte)0x72, (byte)0x69, (byte)0x6E, (byte)0x67, (byte)0x01, (byte)0x00, (byte)0x10, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2F, (byte)0x6C, (byte)0x61, (byte)0x6E, (byte)0x67, (byte)0x2F, (byte)0x4F, (byte)0x62, (byte)0x6A, (byte)0x65, (byte)0x63, (byte)0x74, (byte)0x00, (byte)0x21, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x39, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0B, (byte)0x2A, (byte)0xB7, (byte)0x00, (byte)0x01, (byte)0x2A, (byte)0x12, (byte)0x02, (byte)0xB5, (byte)0x00, (byte)0x03, (byte)0xB1, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x0B, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0A, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0C, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0B, (byte)0x00, (byte)0x0D, (byte)0x00, (byte)0x0E, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0F, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x10 });
    }

    @Test
    public void testMagicNumber()
    {
        assertThat(classFile.getMagicNumber(), equalTo(0xCAFEBABEL));
    }

    @Test
    public void testMinorNumber()
    {
        assertThat(classFile.getMinorVersion(), equalTo(0));
    }

    @Test
    public void testMajorNumber()
    {
        assertThat(classFile.getMajorVersion(), equalTo(55));
    }

    @Test
    public void testConstantPool()
    {
        ConstantPoolEntry entry;

        assertThat(classFile.getConstantPoolCount(), equalTo(21));

        entry = classFile.getConstantPoolEntry(0);
        assertNull(entry);

        entry = classFile.getConstantPoolEntry(1);
        assertNotNull(entry);
        checkMethod(entry, 5, 17);

        entry = classFile.getConstantPoolEntry(2);
        assertNotNull(entry);
        checkString(entry, 18);

        entry = classFile.getConstantPoolEntry(3);
        assertNotNull(entry);
        checkField(entry, 4, 19);

        entry = classFile.getConstantPoolEntry(4);
        assertNotNull(entry);
        checkClass(entry, 20);

        entry = classFile.getConstantPoolEntry(5);
        assertNotNull(entry);
        checkClass(entry, 21);

        entry = classFile.getConstantPoolEntry(6);
        assertNotNull(entry);
        checkUTF8(entry, "x");

        entry = classFile.getConstantPoolEntry(7);
        assertNotNull(entry);
        checkUTF8(entry, "Ljava/lang/String;");

        entry = classFile.getConstantPoolEntry(8);
        assertNotNull(entry);
        checkUTF8(entry, "<init>");

        entry = classFile.getConstantPoolEntry(9);
        assertNotNull(entry);
        checkUTF8(entry, "()V");

        entry = classFile.getConstantPoolEntry(10);
        assertNotNull(entry);
        checkUTF8(entry, "Code");

        entry = classFile.getConstantPoolEntry(11);
        assertNotNull(entry);
        checkUTF8(entry, "LineNumberTable");

        entry = classFile.getConstantPoolEntry(12);
        assertNotNull(entry);
        checkUTF8(entry, "LocalVariableTable");

        entry = classFile.getConstantPoolEntry(13);
        assertNotNull(entry);
        checkUTF8(entry, "this");

        entry = classFile.getConstantPoolEntry(14);
        assertNotNull(entry);
        checkUTF8(entry, "Lca/bcit/comp2526/WithString;");

        entry = classFile.getConstantPoolEntry(15);
        assertNotNull(entry);
        checkUTF8(entry, "SourceFile");

        entry = classFile.getConstantPoolEntry(16);
        assertNotNull(entry);
        checkUTF8(entry, "WithString.java");

        entry = classFile.getConstantPoolEntry(17);
        assertNotNull(entry);
        checkNameAndType(entry, 8, 9);

        entry = classFile.getConstantPoolEntry(18);
        assertNotNull(entry);
        checkUTF8(entry, "Hello, World!");

        entry = classFile.getConstantPoolEntry(19);
        assertNotNull(entry);
        checkNameAndType(entry, 6, 7);

        entry = classFile.getConstantPoolEntry(20);
        assertNotNull(entry);
        checkUTF8(entry, "ca/bcit/comp2526/WithString");

        entry = classFile.getConstantPoolEntry(21);
        assertNotNull(entry);
        checkUTF8(entry, "java/lang/Object");
    }

    @Test
    public void testAccess()
    {
        assertThat(classFile.getAccessFlags(), equalTo(33));
    }

    @Test
    public void testThisClass()
    {
        assertThat(classFile.getThisClass(), equalTo(4));
    }

    @Test
    public void testSuperClass()
    {
        assertThat(classFile.getSuperClass(), equalTo(5));
    }

    @Test
    public void testInterfaces()
    {
        assertThat(classFile.getInterfacesCount(), equalTo(0));
    }
}
