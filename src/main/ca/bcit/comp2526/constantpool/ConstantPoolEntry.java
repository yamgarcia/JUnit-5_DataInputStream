package ca.bcit.comp2526.constantpool;

public class ConstantPoolEntry
{
    private final ConstantPoolType type;
    private final int numberOfSlots;

    public ConstantPoolEntry(final ConstantPoolType t)
    {
        this(t, 1);
    }

    protected ConstantPoolEntry(final ConstantPoolType t,
                                final int slots)
    {
        if(slots < 1 || slots > 2)
        {
            throw new IllegalArgumentException("slots must be 1 or 2, was: " + slots);
        }

        type          = t;
        numberOfSlots = slots;
    }

    public final ConstantPoolType getType()
    {
        return type;
    }

    public final int getNumberOfSlots()
    {
        return numberOfSlots;
    }
}
