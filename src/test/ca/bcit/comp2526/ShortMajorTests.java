package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShortMajorTests
    extends ClassFileTest
{
    @Test
    public void createClassFile()
    {
        final NotEnoughDataException ex;

        ex = assertThrows(NotEnoughDataException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00 }));
        assertThat(ex.getMessage(), equalTo("Require 2 bytes to be available"));
    }
}
