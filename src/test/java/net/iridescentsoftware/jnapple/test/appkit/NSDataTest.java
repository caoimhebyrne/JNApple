package net.iridescentsoftware.jnapple.test.appkit;

import net.iridescentsoftware.jnapple.appkit.NSData;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link NSData}.
 */
class NSDataTest {
    /**
     * Test method for {@link NSData#initWithBytes(byte[])}.
     * Ensures that the correct length for a byte array is returned.
     */
    @Test
    void testCreation() {
        var data = NSData.initWithBytes(new byte[]{1, 2, 3, 4, 5});
        assert data.length() == 5;
    }

    /**
     * Test method for {@link NSData#initWithBytes(byte[])}.
     * Ensures that 0 for a null byte array is returned.
     */
    @Test
    void testEmptyCreation() {
        var data = NSData.initWithBytes(null);
        assert data.length() == 0;
    }
}
