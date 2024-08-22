package dev.caoimhe.jnapple.appkit;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import dev.caoimhe.jnapple.foundation.Foundation;
import dev.caoimhe.jnapple.foundation.NSArray;
import dev.caoimhe.jnapple.foundation.NSObject;
import dev.caoimhe.jnapple.foundation.NSString;

public class NSRunningApplication extends NSObject {
    // NSRunningApplication -> https://developer.apple.com/documentation/appkit/nsrunningapplication?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSRunningApplication");

    // [NSRunningApplication runningApplicationsWithBundleIdentifier]; -> https://developer.apple.com/documentation/appkit/nsrunningapplication/1530798-runningapplicationswithbundleide?language=objc
    private static final Pointer runningApplicationsWithBundleIdentifierSelector = Foundation.INSTANCE.sel_registerName("runningApplicationsWithBundleIdentifier:");

    public NSRunningApplication(NativeLong id) {
        super(id);
    }

    public static NSArray<NSRunningApplication> runningApplicationsWithBundleIdentifier(NSString bundleIdentifier) {
        return new NSArray<>(
            Foundation.INSTANCE.objc_msgSend(nativeClass, runningApplicationsWithBundleIdentifierSelector, bundleIdentifier.getId()),
            NSRunningApplication.class
        );
    }
}