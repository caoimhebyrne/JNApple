package net.iridescentsoftware.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import net.iridescentsoftware.jnapple.foundation.Foundation;
import net.iridescentsoftware.jnapple.foundation.NSObject;

public class NSSavePanel extends NSObject {
    // NSSavePanel -> https://developer.apple.com/documentation/appkit/nssavepanel?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSSavePanel");

    // [NSSavePanel savePanel]; -> https://developer.apple.com/documentation/appkit/nssavepanel/1539016-savepanel?language=objc
    private static final Pointer savePanelPointer = Foundation.INSTANCE.sel_registerName("savePanel");

    // [NSSavePanel runModal] -> https://developer.apple.com/documentation/appkit/nssavepanel/1525357-runmodal?language=objc
    private static final Pointer runModalPointer = Foundation.INSTANCE.sel_registerName("runModal");

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
     * Displays the panel and begins its event loop with the current working (or last-selected) directory as the
     * default starting point.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nssavepanel/1525357-runmodal?language=objc"></a>
     */
    public void runModal() {
        Foundation.INSTANCE.objc_msgSend(getId(), runModalPointer);
    }
}
