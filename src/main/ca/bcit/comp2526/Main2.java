package ca.bcit.comp2526;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author Marcos Garcia
 * @version June 04 2020
 */
public class Main2 {

    public static void main(final String[] argv) throws InvalidMagicNumberException { //main should never throw an exception

        final byte[] data;
        data = new byte[]{ (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x38 };
        try (final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(data))) {


            final long first4 = StreamUtils.readUnsignedInt(stream);
            final int f6bytes = StreamUtils.readUnsignedShort(stream);
            final int f8bytes = StreamUtils.readUnsignedShort(stream);

            System.out.println("first 4 bytes = "+first4);
            System.out.println("next 2 bytes = "+f6bytes);
            System.out.println("last 2 bytes = "+f8bytes);

//            final short byte1 = StreamUtils.readUnsignedByte(stream);
//            final short byte2 = StreamUtils.readUnsignedByte(stream);
//            final short byte3 = StreamUtils.readUnsignedByte(stream);
//            final short byte4 = StreamUtils.readUnsignedByte(stream);
//            final short byte5 = StreamUtils.readUnsignedByte(stream);
//            final short byte6 = StreamUtils.readUnsignedByte(stream);
//            final short byte7 = StreamUtils.readUnsignedByte(stream);
//            final short byte8 = StreamUtils.readUnsignedByte(stream);
//
//            System.out.println("bytes from 1 to 8:");
//            System.out.println(byte1);
//            System.out.println(byte2);
//            System.out.println(byte3);
//            System.out.println(byte4);
//            System.out.println(byte5);
//            System.out.println(byte6);
//            System.out.println(byte7);
//            System.out.println(byte8);


        } catch (final NotEnoughDataException ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace(); //but it'll crash

        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}