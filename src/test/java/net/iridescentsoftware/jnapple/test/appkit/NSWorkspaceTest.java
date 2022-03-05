package net.iridescentsoftware.jnapple.test.appkit;

import net.iridescentsoftware.jnapple.appkit.NSWorkspace;
import net.iridescentsoftware.jnapple.foundation.NSURL;
import org.junit.jupiter.api.Test;

class NSWorkspaceTest {
    @Test
    public void testOpenURL() {
        var url = new NSURL("https://cbyrne.dev");
        NSWorkspace.sharedWorkspace().openURL(url);
    }
}
