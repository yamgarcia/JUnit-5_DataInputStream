package ca.bcit.comp2526;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class StreamUtils
{
    private StreamUtils()
    {
        throw new IllegalStateException("Do not instantiate");
    }

    // this has issues, but will do for now
    private static boolean checkAvailable(final InputStream stream,
                                          final int         required)
        throws IOException
    {
        final int available;

        available = stream.available();

        return available >= required;
    }

    public static void readBytes(final DataInputStream stream,
                                 final byte[]          bytes)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, bytes.length)))
        {
            throw new NotEnoughDataException(bytes.length);
        }

        stream.readFully(bytes);
    }

    public static byte readByte(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 1)))
        {
            throw new NotEnoughDataException(1);
        }

        final byte value;

        value = stream.readByte();

        return value;
    }

    public static short readUnsignedByte(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final byte  value;
        final short unsigned;

        value    = readByte(stream);
        // Why isn't there a Byte.toUnsignedShort?!
        unsigned = (short)Byte.toUnsignedInt(value);

        return unsigned;
    }

    public static short readShort(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 2)))
        {
            throw new NotEnoughDataException(2);
        }

        final short value;

        value = stream.readShort();

        return value;
    }

    public static int readUnsignedShort(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final short value;
        final int   unsigned;

        value    = readShort(stream);
        unsigned = Short.toUnsignedInt(value);

        return unsigned;
    }

    public static int readInt(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 4)))
        {
            throw new NotEnoughDataException(4);
        }

        final int value;

        value = stream.readInt();

        return value;
    }

    public static long readUnsignedInt(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final int value;
        final long unsigned;

        value    = readInt(stream);
        unsigned = Integer.toUnsignedLong(value);

        return unsigned;
    }

    public static float readFloat(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 4)))
        {
            throw new NotEnoughDataException(4);
        }

        final float value;

        value = stream.readFloat();

        return value;
    }


    public static long readLong(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 8)))
        {
            throw new NotEnoughDataException(8);
        }

        final long value;

        value = stream.readLong();

        return value;
    }

    public static double readDouble(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        if(!(checkAvailable(stream, 8)))
        {
            throw new NotEnoughDataException(8);
        }

        final double value;

        value = stream.readDouble();

        return value;
    }
}
