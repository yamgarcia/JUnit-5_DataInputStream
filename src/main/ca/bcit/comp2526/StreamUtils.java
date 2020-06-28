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
    private static void checkAvailable(final InputStream stream,
                                       final int         required)
        throws IOException,
               NotEnoughDataException
    {
        final int available;

        available = stream.available();

        if(available < required)
        {
            throw new NotEnoughDataException(required, available);
        }
    }

    public static void readBytes(final DataInputStream stream,
                                 final byte[]          bytes)
        throws IOException,
               NotEnoughDataException
    {
        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, bytes.length);

        stream.readFully(bytes);
    }

    public static byte readByte(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final byte value;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 1);
        value = stream.readByte();

        return value;
    }

    public static short readUnsignedByte(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final byte  value;
        final short unsigned;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 1);
        value    = readByte(stream);
        // Why isn't there a Byte.toUnsignedShort?!
        unsigned = (short)Byte.toUnsignedInt(value);

        return unsigned;
    }

    public static short readShort(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final short value;
        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 2);
        value = stream.readShort();

        return value;
    }

    public static int readUnsignedShort(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final short value;
        final int   unsigned;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 2);
        value    = readShort(stream);
        unsigned = Short.toUnsignedInt(value);

        return unsigned;
    }

    public static int readInt(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final int value;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 4);
        value = stream.readInt();

        return value;
    }

    public static long readUnsignedInt(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final int value;
        final long unsigned;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 4);
        value    = readInt(stream);
        unsigned = Integer.toUnsignedLong(value);

        return unsigned;
    }

    public static float readFloat(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final float value;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 4);
        value = stream.readFloat();

        return value;
    }

    public static long readLong(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final long value;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 8);
        value = stream.readLong();

        return value;
    }

    public static double readDouble(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException
    {
        final double value;

        if(stream == null)
        {
            throw new IllegalArgumentException("stream cannot be null");
        }

        checkAvailable(stream, 8);
        value = stream.readDouble();

        return value;
    }
}
