package ca.bcit.comp2526;

public class InvalidConstantPoolTagException
    extends ClassFileException
{
    private short tag;

    public InvalidConstantPoolTagException(final short t)
    {
        super("tag must be one of 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19, 20, was: " + t);

        tag = t;
    }

    public short getTag()
    {
        return tag;
    }
}
