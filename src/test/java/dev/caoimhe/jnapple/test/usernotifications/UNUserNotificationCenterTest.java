package dev.caoimhe.jnapple.test.usernotifications;

import dev.caoimhe.jnapple.usernotifications.UNUserNotificationCenter;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link UNUserNotificationCenter}
 */
class UNUserNotificationCenterTest {
    @Test
    void testCurrentNotificationCenter() {
        UNUserNotificationCenter current = UNUserNotificationCenter.currentNotificationCenter();
    }
}
