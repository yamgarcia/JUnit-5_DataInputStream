package ca.bcit.comp2526;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassFile {

    final long MAGIC_NUMBER = 3405691582L;
    final int MAJOR_NUM_MIN = 45;
    final int MAJOR_NUM_MAX = 55;

    public ClassFile(DataInputStream stream) throws ClassFileException, NotEnoughDataException {

        try {

            final long first4 = StreamUtils.readUnsignedInt(stream);
            if (first4 != MAGIC_NUMBER) {
                throw new InvalidMagicNumberException(first4);
            }
            final int f6bytes = StreamUtils.readUnsignedShort(stream);
            final int f8bytes = StreamUtils.readUnsignedShort(stream);
            if (f8bytes < MAJOR_NUM_MIN || f8bytes > MAJOR_NUM_MAX) {
                throw new InvalidMajorVersionException(f8bytes);
            }
        } catch (final NotEnoughDataException ex) {
            throw new NotEnoughDataException(ex.getExpected());

        } catch (final IOException ex) {
            throw new IllegalStateException("Not implemented");

        }
    }


}


