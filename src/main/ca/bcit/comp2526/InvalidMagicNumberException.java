package ca.bcit.comp2526;

public class InvalidMagicNumberException
    extends ClassFileException
{
    private final long magicNumber;

    public InvalidMagicNumberException(final long actual)
    {
        super(String.format("Magic number must be 0x%08X, was: 0x%08X", ClassFile.MAGIC_NUMBER, actual));

        magicNumber = actual;
    }

    public long getMagicNumber()
    {
        return magicNumber;
    }
}
