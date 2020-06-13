package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShortMagic3Tests
    extends ClassFileTest
{
    @Test
    public void createClassFile()
    {
        final NotEnoughDataException ex;

        ex = assertThrows(NotEnoughDataException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, }));
        assertThat(ex.getMessage(), equalTo("Require 4 bytes to be available"));
    }
}
