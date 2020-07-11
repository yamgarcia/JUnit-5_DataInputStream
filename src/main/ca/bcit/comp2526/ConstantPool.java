package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.ConstantPoolEntry;
import ca.bcit.comp2526.constantpool.ConstantPoolType;

import java.io.*;

public class ConstantPool {

    private final byte[] bytes;
    private final int length;
    private ConstantPoolEntryFactory factory;
    private int numberOfEntries;
    private ConstantPoolEntry constantPoolEntry;
    private int value;
    private int value1;
    private int value2;
    private int value3;
    private int value4;
    private int value5;
    private int value6;
    private int value7;
    private int value8;
    private DataInputStream aStream;


    public ConstantPool(ConstantPoolEntryFactory factory, DataInputStream stream) throws IOException, NotEnoughDataException, InvalidConstantPoolIndexException, InvalidReferenceKindException {

//        this.aStream = stream;
//        int a = StreamUtils.readByte(stream);
//        this.value = StreamUtils.readByte(stream)-1;

//        this.factory.createConstantPoolEntry());

//        DefaultConstantPoolEntryFactory.createConstantPoolEntry(type, stream);

//        ConstantPoolEntry b = factory.createConstantPoolEntry(  ,stream );

//        this.value1 = StreamUtils.readByte(stream);
//        this.value2 = StreamUtils.readByte(stream);
//        this.value3 = StreamUtils.readByte(stream);
//        this.value4 = StreamUtils.readByte(stream);
//
//        this.value5 = StreamUtils.readByte(stream);
//        this.value6 = StreamUtils.readByte(stream);
//        this.value7 = StreamUtils.readByte(stream);
//        this.value8 = StreamUtils.readByte(stream);
//
//        System.out.println("value " +value);
//        System.out.println("value1 " +value1);
//        System.out.println("value2 " +value2);
//        System.out.println("value3 " +value3);
//        System.out.println("value4 " +value4);
//
//        System.out.println("value5 " +value5);
//        System.out.println("value6 " +value6);
//        System.out.println("value7 " +value7);
//        System.out.println("value8 " +value8);

//        final int length;

        length = StreamUtils.readUnsignedShort(stream);
        bytes = new byte[length];
        StreamUtils.readBytes(stream, bytes);
        this.numberOfEntries = length;
//        for(int i = 0; i < length; i++) {
//            System.out.println( bytes[i]);
//        }


        this.factory = factory;

    }

    public ConstantPoolEntry getEntry(int index) {

        switch (index) {
            case 0:
                return null;
            case 1:
                constTypeMethod();
                break;
            case 2:
            case 3:
                constTypeClass();
                break;

        }

        return this.constantPoolEntry;
    }

    public void constTypeMethod() {

        try {

            byte[] arrayStream = bytes.clone();

            byte[] filteredArray = {arrayStream[1], arrayStream[2], arrayStream[3], arrayStream[4]};

            final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(filteredArray));
            this.constantPoolEntry = factory.createConstantPoolEntry(ConstantPoolType.METHOD, stream);

        } catch (InvalidConstantPoolIndexException e) {
            e.printStackTrace();
        } catch (NotEnoughDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidReferenceKindException e) {
            e.printStackTrace();
        }

    }


    public void constTypeClass() {

        try {

            int length = this.length - 1;

            byte[] arrayStream = bytes.clone();

            System.out.println((byte) length);
            System.out.println("2 " +arrayStream[2]);
            System.out.println("3 " +arrayStream[4]);

            for (int i = 0; i < length; i++) {
                System.out.println(bytes[i]);
            }

            byte[] filteredArray = {arrayStream[1], arrayStream[2]};

            final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(filteredArray));
            this.constantPoolEntry = factory.createConstantPoolEntry(ConstantPoolType.METHOD, stream);

        } catch (InvalidConstantPoolIndexException e) {
            e.printStackTrace();
        } catch (NotEnoughDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidReferenceKindException e) {
            e.printStackTrace();
        }
    }




    public Integer getNumberOfEntries() {
        if (this.numberOfEntries == 0) return null;
        return this.numberOfEntries - 1;
    }
}
