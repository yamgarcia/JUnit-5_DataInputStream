package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShortMagic2Tests
    extends ClassFileTest
{
    @Test
    public void createClassFile()
    {
        final NotEnoughDataException ex;

        ex = assertThrows(NotEnoughDataException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE }));
        assertThat(ex.getMessage(), equalTo("Require 4 bytes to be available, have: 2"));
    }
}
