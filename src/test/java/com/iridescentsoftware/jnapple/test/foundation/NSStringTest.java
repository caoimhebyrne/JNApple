package com.iridescentsoftware.jnapple.test.foundation;

import com.iridescentsoftware.jnapple.foundation.NSString;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link com.iridescentsoftware.jnapple.foundation.NSString}.
 */
public class NSStringTest {
    /**
     * Test method for {@link com.iridescentsoftware.jnapple.foundation.NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 0 when "" is passed to the constructor.
     */
    @Test
    void testEmptyString() {
        var string = new NSString("");
        assert string.toString().length() == 0;
    }

    /**
     * Test method for {@link com.iridescentsoftware.jnapple.foundation.NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 0 when null is passed to the constructor.
     */
    @Test
    void testNullString() {
        var string = new NSString((String) null);
        assert string.toString().length() == 0;
    }

    /**
     * Test method for {@link com.iridescentsoftware.jnapple.foundation.NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 5 when "Hello" is passed to the constructor.
     */
    @Test
    void testString() {
        var string = new NSString("Hello");
        assert string.toString().length() == 5;
    }
}
