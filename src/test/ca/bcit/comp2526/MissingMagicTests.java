package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissingMagicTests
    extends ClassFileTest
{
    @Test
    public void createClassFile()
    {
        final NotEnoughDataException ex;

        ex = assertThrows(NotEnoughDataException.class, () -> createClassFile(new byte[]{}));
        assertThat(ex.getMessage(), equalTo("Require 4 bytes to be available, have: 0"));
    }
}
