package ca.bcit.comp2526.constantpool;

public abstract class ConstantPoolEntryUnaryTest<T extends ConstantPoolEntry>
    extends ConstantPoolEntryTest<T>
{
    private final int expectedSize;

    protected ConstantPoolEntryUnaryTest(final int expected)
    {
        expectedSize = expected;
    }

    protected final void testNotEnoughData(final byte[] bytes)
    {
        testNotEnoughData(expectedSize, bytes);
    }

    protected final void testNotEnoughData(final int    expectedSize,
                                           final byte[] bytes)
    {
        testNotEnoughData(expectedSize, bytes.length, bytes);
    }
}
