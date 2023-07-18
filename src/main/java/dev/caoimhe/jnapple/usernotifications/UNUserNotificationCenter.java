package dev.caoimhe.jnapple.usernotifications;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import dev.caoimhe.jnapple.foundation.NSObject;

public class UNUserNotificationCenter extends NSObject {
    // UNUserNotificationCenter -> https://developer.apple.com/documentation/usernotifications/unusernotificationcenter?language=objc
    private static final Pointer nativeClass = UserNotifications.INSTANCE.objc_getClass("UNUserNotificationCenter");

    // [UNUserNotificationCenter currentNotificationCenter]; -> https://developer.apple.com/documentation/usernotifications/unusernotificationcenter/1649510-currentnotificationcenter?language=objc
    private static final Pointer currentNotificationCenterSelector = UserNotifications.INSTANCE.sel_registerName("currentNotificationCenter");

    /**
     * Required by NSObject inheritance
     *
     * @param id The pointer to the object
     */
    public UNUserNotificationCenter(NativeLong id) {
        super(id);
    }

    // https://developer.apple.com/documentation/usernotifications/unusernotificationcenter/1649510-currentnotificationcenter?language=objc
    public static UNUserNotificationCenter currentNotificationCenter() {
        NativeLong pointer = UserNotifications.INSTANCE.objc_msgSend(nativeClass, currentNotificationCenterSelector);
        return new UNUserNotificationCenter(pointer);
    }
}
