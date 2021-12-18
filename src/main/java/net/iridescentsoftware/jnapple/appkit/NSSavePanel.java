package net.iridescentsoftware.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import net.iridescentsoftware.jnapple.foundation.Foundation;
import net.iridescentsoftware.jnapple.foundation.NSObject;
import net.iridescentsoftware.jnapple.foundation.NSURL;

/**
 * This is an abstraction of some of the methods from NSSavePanel.
 * <p>
 * This may seem un-neccessary, but we would like to share some methods like runModal, showsHiddenFiles, etc. without
 * sharing NSSavePanel specific stuff like savePanel.
 */
class NSFilePanel extends NSObject {
    // [NSSavePanel setCanCreateDirectories:] -> https://developer.apple.com/documentation/appkit/nssavepanel/1532626-cancreatedirectories?language=objc
    private static final Pointer setCanCreateDirectoriesPointer = Foundation.INSTANCE.sel_registerName("setCanCreateDirectories:");

    // [NSSavePanel runModal] -> https://developer.apple.com/documentation/appkit/nssavepanel/1525357-runmodal?language=objc
    private static final Pointer runModalPointer = Foundation.INSTANCE.sel_registerName("runModal");

    public NSFilePanel(NativeLong id) {
        super(id);
    }

    /**
     * Whether the panel displays UI for creating directories.
     * When the value of this is `true`, the panel includes UI to create new directories.
     * When the value is `no`, the panel does not expose that UI.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nssavepanel/1532626-cancreatedirectories?language=objc"></a>
     */
    public void setCanCreateDirectories(boolean canCreateDirectories) {
        Foundation.INSTANCE.objc_msgSend(getId(), setCanCreateDirectoriesPointer, canCreateDirectories);
    }

    /**
     * Displays the panel and begins its event loop with the current working (or last-selected) directory as the
     * default starting point.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nssavepanel/1525357-runmodal?language=objc"></a>
     */
    public NSAlert.NSModalResponse runModal() {
        var value = Foundation.INSTANCE.objc_msgSend(getId(), runModalPointer).intValue();
        return NSAlert.NSModalResponse.from(value);
    }
}

public class NSSavePanel extends NSFilePanel {
    // NSSavePanel -> https://developer.apple.com/documentation/appkit/nssavepanel?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSSavePanel");

    // [NSSavePanel savePanel]; -> https://developer.apple.com/documentation/appkit/nssavepanel/1539016-savepanel?language=objc
    private static final Pointer savePanelPointer = Foundation.INSTANCE.sel_registerName("savePanel");

    // [NSSavePanel URL]; -> https://developer.apple.com/documentation/appkit/nssavepanel/1534384-url?language=objc
    private static final Pointer urlPointer = Foundation.INSTANCE.sel_registerName("URL");

    public NSSavePanel(NativeLong id) {
        super(id);
    }

    /**
     * Creates a new Save panel and initializes it with default information.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nssavepanel/1539016-savepanel?language=objc"></a>
     */
    public static NSSavePanel savePanel() {
        return new NSSavePanel(Foundation.INSTANCE.objc_msgSend(nativeClass, savePanelPointer));
    }

    /**
     * A URL that contains the fully specified location of the targeted file.
     */
    public NSURL getURL() {
        return new NSURL(Foundation.INSTANCE.objc_msgSend(getId(), urlPointer));
    }
}
