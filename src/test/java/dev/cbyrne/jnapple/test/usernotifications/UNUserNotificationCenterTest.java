package dev.cbyrne.jnapple.test.usernotifications;

import dev.cbyrne.jnapple.usernotifications.UNUserNotificationCenter;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link UNUserNotificationCenter}
 */
class UNUserNotificationCenterTest {
    @Test
    void testCurrentNotificationCenter() {
        var current = UNUserNotificationCenter.currentNotificationCenter();
    }
}
