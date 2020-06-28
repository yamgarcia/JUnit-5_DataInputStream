package ca.bcit.comp2526;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class ByteUtils
{
    private ByteUtils()
    {
        throw new IllegalStateException("Do not create instances");
    }

    public static byte[] byteToBytes(final byte value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeByte(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] unsignedByteToBytes(final int value)
            throws IOException
    {
        final byte[] bytes;

        bytes = byteToBytes((byte)value);

        return bytes;
    }

    public static byte[] shortToBytes(final short value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeShort(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] unsignedShortToBytes(final int value)
            throws IOException
    {
        final byte[] bytes;

        bytes = shortToBytes((short)value);

        return bytes;
    }

    public static byte[] intToBytes(final int value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeInt(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] unsignedIntToBytes(final long value)
            throws IOException
    {
        final byte[] bytes;

        bytes = intToBytes((int)value);

        return bytes;
    }

    public static byte[] longToBytes(final long value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeLong(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] floatToBytes(final float value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeFloat(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] doubleToBytes(final double value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeDouble(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }

    public static byte[] stringToBytes(final String value)
            throws IOException
    {
        final ByteArrayOutputStream byteStream;

        byteStream = new ByteArrayOutputStream();

        try(final var stream = new DataOutputStream(byteStream))
        {
            final byte[] bytes;

            stream.writeBytes(value);
            bytes = byteStream.toByteArray();

            return bytes;
        }
    }
}
