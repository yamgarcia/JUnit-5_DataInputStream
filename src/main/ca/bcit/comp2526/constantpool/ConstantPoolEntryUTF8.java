package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.NotEnoughDataException;
import ca.bcit.comp2526.StreamUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConstantPoolEntryUTF8
        extends ConstantPoolEntry {

    private int arrSize;
    private byte[] byteArr;
    private String message;
    private final static int SLOTS = 1;

    public ConstantPoolEntryUTF8(DataInputStream stream)
            throws IOException, NotEnoughDataException {

        // get the array size
        this.arrSize = StreamUtils.readUnsignedShort(stream);

        byteArr = new byte[this.arrSize];
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = StreamUtils.readByte(stream);
        }

        // get the message
        this.message = new String(byteArr, StandardCharsets.UTF_8);

//        StreamUtils.readBytes(stream, byteArr);
    }

    public byte[] getBytes() {
        return this.byteArr;
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