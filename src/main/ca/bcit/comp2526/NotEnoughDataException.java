package ca.bcit.comp2526;

public class NotEnoughDataException
    extends Exception
{
    private final int expected;

    public NotEnoughDataException(final int expected)
    {
        super(String.format("Require %d bytes to be available", expected));

        this.expected = expected;
    }

    public int getExpected()
    {
        return expected;
    }
}
