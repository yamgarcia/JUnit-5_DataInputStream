package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BadMagicTests
    extends ClassFileTest
{
    @Test
    public void badMagicNumber1()
    {
        final InvalidMagicNumberException ex;

        ex = assertThrows(InvalidMagicNumberException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBD }));
        assertThat(ex.getMessage(), equalTo("Magic number must be 0xCAFEBABE, was: 0xCAFEBABD"));
    }

    @Test
    public void badMagicNumber2()
    {
        final InvalidMagicNumberException ex;

        ex = assertThrows(InvalidMagicNumberException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBC }));
        assertThat(ex.getMessage(), equalTo("Magic number must be 0xCAFEBABE, was: 0xCAFEBABC"));
    }
}
