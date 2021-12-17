package net.iridescentsoftware.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import net.iridescentsoftware.jnapple.foundation.Foundation;

public class NSOpenPanel extends NSSavePanel {
    // NSOpenPanel -> https://developer.apple.com/documentation/appkit/nsopenpanel?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSOpenPanel");

    // [NSOpenPanel openPanel] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1584365-openpanel?language=objc;
    private static final Pointer openPanelPointer = Foundation.INSTANCE.sel_registerName("openPanel");

    // [NSOpenPanel setCanChooseFiles:] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1527060-canchoosefiles?language=objc
    private static final Pointer setCanChooseFilesPointer = Foundation.INSTANCE.sel_registerName("setCanChooseFiles:");

    public NSOpenPanel(NativeLong id) {
        super(id);
    }

    /**
     * Creates a new Open panel and initializes it with a default configuration.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nsopenpanel/1584365-openpanel?language=objc"></a>
     */
    public static NSOpenPanel openPanel() {
        return new NSOpenPanel(Foundation.INSTANCE.objc_msgSend(nativeClass, openPanelPointer));
    }

    /**
     * Whether the user can choose files in the panel.
     * When called with `true`, users can choose files in the panel.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nsopenpanel/1527060-canchoosefiles?language=objc"></a>
     */
    public void setSetCanChooseFiles(boolean canChooseFiles) {
        Foundation.INSTANCE.objc_msgSend(getId(), setCanChooseFilesPointer, canChooseFiles);
    }
}
