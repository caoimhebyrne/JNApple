package dev.caoimhe.jnapple.test.appkit;

import dev.caoimhe.jnapple.appkit.NSRunningApplication;
import dev.caoimhe.jnapple.foundation.NSArray;
import dev.caoimhe.jnapple.foundation.NSString;
import org.junit.jupiter.api.Test;

public class NSRunningApplicationTest {
    @Test
    public void itWorks() {
        try (NSString bundleIdentifier = new NSString("com.apple.finder")) {
            NSArray<NSRunningApplication> applications = NSRunningApplication.runningApplicationsWithBundleIdentifier(bundleIdentifier);
            assert applications.count() == 1;
        }
    }
}
