package dev.caoimhe.jnapple.test.appkit;

import dev.caoimhe.jnapple.appkit.NSWorkspace;
import dev.caoimhe.jnapple.foundation.NSURL;
import org.junit.jupiter.api.Test;

class NSWorkspaceTest {
    @Test
    public void testOpenURL() {
        NSURL url = new NSURL("https://caoimhe.dev");
        NSWorkspace.sharedWorkspace().openURL(url);
    }
}
