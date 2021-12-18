package net.iridescentsoftware.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import net.iridescentsoftware.jnapple.foundation.Foundation;
import net.iridescentsoftware.jnapple.foundation.NSArray;
import net.iridescentsoftware.jnapple.foundation.NSURL;

public class NSOpenPanel extends NSFilePanel {
    // NSOpenPanel -> https://developer.apple.com/documentation/appkit/nsopenpanel?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSOpenPanel");

    // [NSOpenPanel openPanel] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1584365-openpanel?language=objc;
    private static final Pointer openPanelSelector = Foundation.INSTANCE.sel_registerName("openPanel");

    // [NSOpenPanel setCanChooseFiles:] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1527060-canchoosefiles?language=objc
    private static final Pointer setCanChooseFilesSelector = Foundation.INSTANCE.sel_registerName("setCanChooseFiles:");

    // [NSOpenPanel setCanChooseFiles:] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1527060-canchoosefiles?language=objc
    private static final Pointer setAllowsMultipleSelectionSelector = Foundation.INSTANCE.sel_registerName("setAllowsMultipleSelection:");

    // [NSOpenPanel URLs] -> https://developer.apple.com/documentation/appkit/nsopenpanel/1529845-urls?language=objc
    private static final Pointer urlsSelector = Foundation.INSTANCE.sel_registerName("URLs");

    public NSOpenPanel(NativeLong id) {
        super(id);
    }

    /**
     * Creates a new Open panel and initializes it with a default configuration.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nsopenpanel/1584365-openpanel?language=objc"></a>
     */
    public static NSOpenPanel openPanel() {
        return new NSOpenPanel(Foundation.INSTANCE.objc_msgSend(nativeClass, openPanelSelector));
    }

    /**
     * Whether the user can choose files in the panel.
     * When called with `true`, users can choose files in the panel.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nsopenpanel/1527060-canchoosefiles?language=objc"></a>
     */
    public void setCanChooseFiles(boolean canChooseFiles) {
        Foundation.INSTANCE.objc_msgSend(getId(), setCanChooseFilesSelector, canChooseFiles);
    }

    /**
     * Whether the user may select multiple files and directories.
     * When the value of this property is `true`, the user may select multiple items from the browser.
     *
     * @see <a href="https://developer.apple.com/documentation/appkit/nsopenpanel/1530786-allowsmultipleselection?language=objc">Apple Documentation</a>
     */
    public void setAllowsMultipleSelection(boolean allowsMultipleSelection) {
        Foundation.INSTANCE.objc_msgSend(getId(), setAllowsMultipleSelectionSelector, allowsMultipleSelection);
    }

    /**
     * An array of URLs, each of which contains the fully specified location of a selected file or directory.
     * This property contains a valid value when the user selects one item or multiple items.
     *
     * @return An NSArray of @{@link net.iridescentsoftware.jnapple.foundation.NSURL}.
     */
    public NSArray<NSURL> getURLs() {
        return new NSArray<>(Foundation.INSTANCE.objc_msgSend(getId(), urlsSelector), NSURL.class);
    }
}
