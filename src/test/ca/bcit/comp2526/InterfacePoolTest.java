package ca.bcit.comp2526;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterfacePoolTest
{
    private InterfacePool poolA;
    private InterfacePool poolB;
    private InterfacePool poolC;
    private InterfacePool poolD;

    @BeforeAll
    public void createClassFile()
            throws IOException,
            NotEnoughDataException,
            InvalidConstantPoolIndexException,
            InvalidReferenceKindException,
            InvalidConstantPoolTagException
    {
        poolA = createInterfacePool(new byte[] { (byte)0x00, (byte)0x00 });
        poolB = createInterfacePool(new byte[] { (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x06, (byte)0x00, (byte)0x07, (byte)0x00, (byte)0x08 });
        poolC = createInterfacePool(new byte[] { (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x03 });
        poolD = createInterfacePool(new byte[] { (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x04 });
    }

    protected InterfacePool createInterfacePool(final byte[] bytes)
            throws IOException,
            NotEnoughDataException
    {
        try(final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes)))
        {
            final InterfacePool interfacePool;

            interfacePool = new InterfacePool(stream);

            return interfacePool;
        }
    }

    @Test
    public void testGetCount()
    {
        assertThat(poolA.getNumberOfEntries(), equalTo(0));
        assertThat(poolB.getNumberOfEntries(), equalTo(5));
        assertThat(poolC.getNumberOfEntries(), equalTo(1));
        assertThat(poolD.getNumberOfEntries(), equalTo(1));
    }

    @Test
    public void testPoolB()
    {
        testEntry(poolB, 0, 4);
        testEntry(poolB, 1, 5);
        testEntry(poolB, 2, 6);
        testEntry(poolB, 3, 7);
        testEntry(poolB, 4, 8);
    }

    @Test
    public void testPoolC()
    {
        testEntry(poolC, 0, 3);
    }

    @Test
    public void testPoolD()
    {
        testEntry(poolD, 0, 4);
    }

    private void testEntry(final InterfacePool pool,
                           final int index,
                           final int expected)
    {
        final int actual;

        actual = pool.getInterface(index);
        assertThat(actual, equalTo(expected));
    }
}
