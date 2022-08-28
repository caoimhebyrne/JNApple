package dev.cbyrne.jnapple.test.appkit;

import dev.cbyrne.jnapple.appkit.NSWorkspace;
import dev.cbyrne.jnapple.foundation.NSURL;
import org.junit.jupiter.api.Test;

class   NSWorkspaceTest {
    @Test
    public void testOpenURL() {
        var url = new NSURL("https://cbyrne.dev");
        NSWorkspace.sharedWorkspace().openURL(url);
    }
}
