package ca.bcit.comp2526;

public class InvalidConstantPoolIndexException
        extends ClassFileException
{
    private final int index;

    public InvalidConstantPoolIndexException(final String name,
                                             final int idx)
    {
        super(String.format("%s must be > 0, was: %d", name, idx));

        index = idx;
    }

    public int getIndex()
    {
        return index;
    }
}
