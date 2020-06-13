package ca.bcit.comp2526;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public abstract class ClassFileTest
{
    protected ClassFile createClassFile(final byte[] bytes)
        throws IOException,
               NotEnoughDataException,
               ClassFileException
    {
        try(final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes)))
        {
            final ClassFile classFile;

            classFile = new ClassFile(stream);

            return classFile;
        }
    }
}