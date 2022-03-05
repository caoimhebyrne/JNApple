package net.iridescentsoftware.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import net.iridescentsoftware.jnapple.foundation.Foundation;
import net.iridescentsoftware.jnapple.foundation.NSObject;
import net.iridescentsoftware.jnapple.foundation.NSURL;

public class NSWorkspace extends NSObject {
    // NSWorkspace -> https://developer.apple.com/documentation/appkit/nsworkspace?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSWorkspace");

    // [NSWorkspace sharedWorkspace]; -> https://developer.apple.com/documentation/appkit/nsworkspace/1530344-sharedworkspace?language=objc
    private static final Pointer sharedWorkspaceSelector = Foundation.INSTANCE.sel_registerName("sharedWorkspace");

    // [NSWorkspace sharedWorkspace]; -> https://developer.apple.com/documentation/appkit/nsworkspace/1533463-openurl?language=objc
    private static final Pointer openURLSelector = Foundation.INSTANCE.sel_registerName("openURL:");

    public NSWorkspace(NativeLong id) {
        super(id);
    }

    /**
     * The shared workspace object.
     *
     * @return The NSWorkspace object associated with the process.
     */
    public static NSWorkspace sharedWorkspace() {
        return new NSWorkspace(Foundation.INSTANCE.objc_msgSend(nativeClass, sharedWorkspaceSelector));
    }

    /**
     * Opens the location at the specified URL.
     *
     * @param url A URL specifying the location to open.
     */
    public void openURL(NSURL url) {
        Foundation.INSTANCE.objc_msgSend(getId(), openURLSelector, url.getId());
    }
}
