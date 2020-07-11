package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryUTF8
        extends ConstantPoolEntry
{
    private final byte[] bytes;
    private final String string;

    public ConstantPoolEntryUTF8(final DataInputStream stream)
            throws IOException,
            NotEnoughDataException
    {
        super(ConstantPoolType.UTF8);

        final int length;

        length = StreamUtils.readUnsignedShort(stream);
        bytes = new byte[length];
        StreamUtils.readBytes(stream, bytes);
        string = new String(bytes);
    }

    public byte[] getBytes()
    {
        return bytes.clone();
    }

    public String getString()
    {
        return string;
    }
}
