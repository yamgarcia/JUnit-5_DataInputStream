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
public class ModuleInfoTests
    extends ClassFileTest
{
    private ClassFile classFile;

    @BeforeAll
    public void createClassFile()
        throws IOException,
            NotEnoughDataException,
            ClassFileException
    {
        classFile = createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x37, (byte)0x00, (byte)0x0F, (byte)0x07, (byte)0x00, (byte)0x0A, (byte)0x01, (byte)0x00, (byte)0x0A, (byte)0x53, (byte)0x6F, (byte)0x75, (byte)0x72, (byte)0x63, (byte)0x65, (byte)0x46, (byte)0x69, (byte)0x6C, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x10, (byte)0x6D, (byte)0x6F, (byte)0x64, (byte)0x75, (byte)0x6C, (byte)0x65, (byte)0x2D, (byte)0x69, (byte)0x6E, (byte)0x66, (byte)0x6F, (byte)0x2E, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x4D, (byte)0x6F, (byte)0x64, (byte)0x75, (byte)0x6C, (byte)0x65, (byte)0x13, (byte)0x00, (byte)0x0B, (byte)0x13, (byte)0x00, (byte)0x0C, (byte)0x01, (byte)0x00, (byte)0x06, (byte)0x31, (byte)0x31, (byte)0x2E, (byte)0x30, (byte)0x2E, (byte)0x35, (byte)0x13, (byte)0x00, (byte)0x0D, (byte)0x14, (byte)0x00, (byte)0x0E, (byte)0x01, (byte)0x00, (byte)0x0B, (byte)0x6D, (byte)0x6F, (byte)0x64, (byte)0x75, (byte)0x6C, (byte)0x65, (byte)0x2D, (byte)0x69, (byte)0x6E, (byte)0x66, (byte)0x6F, (byte)0x01, (byte)0x00, (byte)0x1B, (byte)0x6C, (byte)0x61, (byte)0x7A, (byte)0x79, (byte)0x2E, (byte)0x63, (byte)0x6F, (byte)0x6E, (byte)0x73, (byte)0x74, (byte)0x61, (byte)0x6E, (byte)0x74, (byte)0x2E, (byte)0x76, (byte)0x61, (byte)0x6C, (byte)0x75, (byte)0x65, (byte)0x70, (byte)0x72, (byte)0x6F, (byte)0x76, (byte)0x69, (byte)0x64, (byte)0x65, (byte)0x72, (byte)0x01, (byte)0x00, (byte)0x09, (byte)0x6A, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2E, (byte)0x62, (byte)0x61, (byte)0x73, (byte)0x65, (byte)0x01, (byte)0x00, (byte)0x0D, (byte)0x6E, (byte)0x65, (byte)0x74, (byte)0x2E, (byte)0x62, (byte)0x79, (byte)0x74, (byte)0x65, (byte)0x62, (byte)0x75, (byte)0x64, (byte)0x64, (byte)0x79, (byte)0x01, (byte)0x00, (byte)0x18, (byte)0x64, (byte)0x65, (byte)0x76, (byte)0x2F, (byte)0x6D, (byte)0x6F, (byte)0x72, (byte)0x6C, (byte)0x69, (byte)0x6E, (byte)0x67, (byte)0x2F, (byte)0x6C, (byte)0x61, (byte)0x7A, (byte)0x79, (byte)0x63, (byte)0x6F, (byte)0x6E, (byte)0x73, (byte)0x74, (byte)0x61, (byte)0x6E, (byte)0x74, (byte)0x80, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x22, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x06, (byte)0x80, (byte)0x00, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x09, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00 });
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

        assertThat(classFile.getConstantPoolCount(), equalTo(14));

        entry = classFile.getConstantPoolEntry(0);
        assertNull(entry);

        entry = classFile.getConstantPoolEntry(1);
        assertNotNull(entry);
        checkClass(entry, 10);

        entry = classFile.getConstantPoolEntry(2);
        assertNotNull(entry);
        checkUTF8(entry, "SourceFile");

        entry = classFile.getConstantPoolEntry(3);
        assertNotNull(entry);
        checkUTF8(entry, "module-info.java");

        entry = classFile.getConstantPoolEntry(4);
        assertNotNull(entry);
        checkUTF8(entry, "Module");

        entry = classFile.getConstantPoolEntry(5);
        assertNotNull(entry);
        checkModule(entry, 11);

        entry = classFile.getConstantPoolEntry(6);
        assertNotNull(entry);
        checkModule(entry, 12);

        entry = classFile.getConstantPoolEntry(7);
        assertNotNull(entry);
        checkUTF8(entry, "11.0.5");

        entry = classFile.getConstantPoolEntry(8);
        assertNotNull(entry);
        checkModule(entry, 13);

        entry = classFile.getConstantPoolEntry(9);
        assertNotNull(entry);
        checkPackage(entry, 14);

        entry = classFile.getConstantPoolEntry(10);
        assertNotNull(entry);
        checkUTF8(entry, "module-info");

        entry = classFile.getConstantPoolEntry(11);
        assertNotNull(entry);
        checkUTF8(entry, "lazy.constant.valueprovider");

        entry = classFile.getConstantPoolEntry(12);
        assertNotNull(entry);
        checkUTF8(entry, "java.base");

        entry = classFile.getConstantPoolEntry(13);
        assertNotNull(entry);
        checkUTF8(entry, "net.bytebuddy");

        entry = classFile.getConstantPoolEntry(14);
        assertNotNull(entry);
        checkUTF8(entry, "dev/morling/lazyconstant");
    }

    @Test
    public void testAccess()
    {
        assertThat(classFile.getAccessFlags(), equalTo(32768));
    }

    @Test
    public void testThisClass()
    {
        assertThat(classFile.getThisClass(), equalTo(1));
    }

    @Test
    public void testSuperClass()
    {
        assertThat(classFile.getSuperClass(), equalTo(0));
    }

    @Test
    public void testInterfaces()
    {
        assertThat(classFile.getInterfacesCount(), equalTo(0));
    }
}
