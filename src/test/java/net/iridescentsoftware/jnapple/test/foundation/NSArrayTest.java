package net.iridescentsoftware.jnapple.test.foundation;

import net.iridescentsoftware.jnapple.foundation.NSArray;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link NSArray}.
 */
public class NSArrayTest {
    /**
     * Test method for {@link NSArray#array()}.
     * Ensures that the count is 0 when an empty array is created.
     */
    @Test
    void testEmptyArray() {
        var array = NSArray.array();
        assert array.count() == 0;
    }
}
