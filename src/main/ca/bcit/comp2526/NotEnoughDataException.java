package ca.bcit.comp2526;

public class NotEnoughDataException
    extends Exception
{
    private final int expected;
    private final int actual;

    public NotEnoughDataException(final int expected, final int actual)
    {
        super(String.format("Require %d bytes to be available, have: %d", expected, actual));

        this.expected = expected;
        this.actual   = actual;
    }

    public int getExpected()
    {
        return expected;
    }

    public int getActual()
    {
        return actual;
    }
}
