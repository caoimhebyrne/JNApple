package net.iridescentsoftware.jnapple.foundation;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * A reference to an NSArray object, which is a 'static array' that can not be modified.
 */
public class NSArray extends NSObject {
    // NSArray -> https://developer.apple.com/documentation/foundation/nsarray?language=objc
    private static final Pointer nativeClass = Foundation.INSTANCE.objc_getClass("NSArray");

    // [NSArray array]; -> https://developer.apple.com/documentation/foundation/nsarray/1460120-array?language=objc
    private static final Pointer arraySelector = Foundation.INSTANCE.sel_registerName("array");

    // [NSArray count]; -> https://developer.apple.com/documentation/foundation/nsarray/1409982-count?language=objc
    private static final Pointer countSelector = Foundation.INSTANCE.sel_registerName("count");

    // [NSArray firstObject]; -> https://developer.apple.com/documentation/foundation/nsarray/1412852-firstobject?language=objc
    private static final Pointer firstObjectSelector = Foundation.INSTANCE.sel_registerName("firstObject");

    // [NSArray lastObject]; -> https://developer.apple.com/documentation/foundation/nsarray/1408316-lastobject?language=objc
    private static final Pointer lastObjectSelector = Foundation.INSTANCE.sel_registerName("lastObject");

    // [NSArray objectAtIndex:]; -> https://developer.apple.com/documentation/foundation/nsarray/1417555-objectatindex?language=objc
    private static final Pointer objectAtIndexSelector = Foundation.INSTANCE.sel_registerName("objectAtIndex:");

    public NSArray(NativeLong id) {
        super(id);
    }

    /**
     * Creates and returns an empty array.
     *
     * @return An empty NSArray instance.
     */
    public static NSArray array() {
        return new NSArray(Foundation.INSTANCE.objc_msgSend(nativeClass, arraySelector));
    }

    /**
     * The number of objects in the array.
     */
    public int count() {
        return Foundation.INSTANCE.objc_msgSend(getId(), countSelector).intValue();
    }

    /**
     * The first object in the array.
     *
     * @return If the array is empty, returns null, otherwise an NSObject instance.
     */
    public NSObject firstObject() {
        return new NSObject(Foundation.INSTANCE.objc_msgSend(getId(), firstObjectSelector));
    }

    /**
     * The last object in the array.
     *
     * @return If the array is empty, returns null, otherwise an NSObject instance.
     */
    public NSObject lastObject() {
        return new NSObject(Foundation.INSTANCE.objc_msgSend(getId(), lastObjectSelector));
    }

    /**
     * Returns the object located at the specified index.
     * <p>
     * If `index` is beyond the end of the array (that is, if index is greater than or equal to the value returned by count),
     * an NSRangeException is raised.
     *
     * @param index An index within the bounds of the array.
     * @return If the array is empty, returns null, otherwise the NSObject instance located at the index.
     * @see <a href="https://developer.apple.com/documentation/foundation/nsarray/1417555-objectatindex?language=objc"></a>
     */
    public NSObject objectAtIndex(int index) {
        return new NSObject(Foundation.INSTANCE.objc_msgSend(getId(), objectAtIndexSelector, index));
    }
}
