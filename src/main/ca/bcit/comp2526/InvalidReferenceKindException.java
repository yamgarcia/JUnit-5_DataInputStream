package ca.bcit.comp2526;

public class InvalidReferenceKindException
    extends ClassFileException
{
    private final short value;

    public InvalidReferenceKindException(final short val)
    {
        super("referenceKind must be between 1 and 9, was: " + val);

        value = val;
    }

    public short getValue()
    {
        return value;
    }
}
