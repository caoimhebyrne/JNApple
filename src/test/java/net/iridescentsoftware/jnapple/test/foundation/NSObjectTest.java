package net.iridescentsoftware.jnapple.test.foundation;

import com.sun.jna.NativeLong;
import net.iridescentsoftware.jnapple.foundation.NSObject;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link NSObject}.
 */
public class NSObjectTest {
    /**
     * Test method for {@link NSObject#NSObject(NativeLong)}.
     * Ensures that the constructor works as expected.
     */
    @Test
    void testNullCreation() {
        var obj = new NSObject(new NativeLong(0));
        assert obj.isNull();
    }
}
