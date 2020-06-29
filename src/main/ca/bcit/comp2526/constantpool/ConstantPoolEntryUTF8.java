package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantPoolEntryUTF8
        extends ConstantPoolEntry {

    private final static int SLOTS = 1;
    private String message;
    private byte[] bytes;

    public ConstantPoolEntryUTF8(DataInputStream stream)
            throws IOException, NotEnoughDataException {

        final int length;

        length = StreamUtils.readUnsignedShort(stream);
        bytes = new byte[length];

        StreamUtils.readBytes(stream, bytes);
        this.message = new String(bytes);
    }

    public byte[] getBytes() {
        return this.bytes.clone();
    }

    public ConstantPoolType getType() {
        return ConstantPoolType.UTF8;
    }

    public String getString() {
        return this.message;
    }

    public int getNumberOfSlots() {
        return SLOTS;
    }
}