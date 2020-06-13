package ca.bcit.comp2526;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BadMagicTests
    extends ClassFileTest
{
    @Test
    public void badMagicNumber1()
    {
        final InvalidMagicNumberException ex;

        ex = assertThrows(InvalidMagicNumberException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBD }));
        assertThat(ex.getMessage(), equalTo("Magic number must be 3405691582, was: 3405691581"));
    }

    @Test
    public void badMagicNumber2()
    {
        final InvalidMagicNumberException ex;

        ex = assertThrows(InvalidMagicNumberException.class, () -> createClassFile(new byte[] { (byte)0xCA, (byte)0xFE, (byte)0xBA, (byte)0xBC }));
        assertThat(ex.getMessage(), equalTo("Magic number must be 3405691582, was: 3405691580"));
    }
}
