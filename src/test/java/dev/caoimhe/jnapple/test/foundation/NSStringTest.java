package dev.caoimhe.jnapple.test.foundation;

import dev.caoimhe.jnapple.foundation.NSString;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link NSString}.
 */
public class NSStringTest {
    /**
     * Test method for {@link NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 0 when "" is passed to the constructor.
     */
    @Test
    void testEmptyString() {
        NSString string = new NSString("");
        assert string.toString().length() == 0;
    }

    /**
     * Test method for {@link NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 0 when null is passed to the constructor.
     */
    @Test
    void testNullString() {
        NSString string = new NSString((String) null);
        assert string.toString().length() == 0;
    }

    /**
     * Test method for {@link NSString#NSString(java.lang.String)}.
     * Ensures that the CFString's length is 5 when "Hello" is passed to the constructor.
     */
    @Test
    void testString() {
        NSString string = new NSString("Hello");
        assert string.toString().length() == 5;

        string.close();
        System.out.println(string.getJvmString());
    }
}
