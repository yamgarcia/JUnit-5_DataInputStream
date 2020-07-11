package ca.bcit.comp2526;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfacePool {

    private int entries;
    private int entries1;
    private int entries2;
    private int entries3;
    private int entries4;

    public InterfacePool(DataInputStream stream) throws IOException, NotEnoughDataException {
        this.entries = StreamUtils.readUnsignedShort(stream);

    }

    public int getNumberOfEntries() {
        return this.entries;
    }

    public int getInterface(int index) {
        return 0;
    }
}
