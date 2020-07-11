package ca.bcit.comp2526;

public class InvalidMajorVersionException
    extends ClassFileException
{

    private final int major;

    public InvalidMajorVersionException(final int actual,
                                        final int smallest,
                                        final int largest)
    {
        super(String.format("Major number must be between %d and %d, was: %d", smallest, largest, actual));

        major = actual;
    }

    public int getMajor()
    {
        return major;
    }
}
