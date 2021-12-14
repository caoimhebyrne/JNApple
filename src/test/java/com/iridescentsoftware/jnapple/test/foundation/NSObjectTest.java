package com.iridescentsoftware.jnapple.test.foundation;

import com.iridescentsoftware.jnapple.foundation.NSObject;
import com.sun.jna.NativeLong;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link com.iridescentsoftware.jnapple.foundation.NSObject}.
 */
public class NSObjectTest {
    /**
     * Test method for {@link com.iridescentsoftware.jnapple.foundation.NSObject#NSObject(NativeLong)}.
     * Ensures that the constructor works as expected.
     */
    @Test
    void testNullCreation() {
        var obj = new NSObject(new NativeLong(0));
        assert obj.isNull();
    }
}
