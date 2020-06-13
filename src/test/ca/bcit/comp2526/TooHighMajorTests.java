package ca.bcit.comp2526;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TooHighMajorTests
    extends ClassFileTest
{
    @Test
    public void majorTooHigh1()
    {
        final InvalidMajorVersionException ex;

        ex = assertThrows(InvalidMajorVersionException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x38 }));
        assertThat(ex.getMessage(), equalTo("Major number must be between 45 and 55, was: 56"));
    }
    @Test
    public void majorTooHigh2()
    {
        final InvalidMajorVersionException ex;

        ex = assertThrows(InvalidMajorVersionException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBE, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x39 }));
        assertThat(ex.getMessage(), equalTo("Major number must be between 45 and 55, was: 57"));
    }
}
