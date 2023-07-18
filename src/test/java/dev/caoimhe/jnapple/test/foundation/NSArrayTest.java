package dev.caoimhe.jnapple.test.foundation;

import dev.caoimhe.jnapple.foundation.NSArray;
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
        NSArray array = NSArray.array();
        assert array.count() == 0;
    }
}
