# JNApple

🍏 A collection of partial JNA bindings for various macOS frameworks. (e.g. Foundation, AppKit, etc.)

## Usage

These are just some common examples, for a wider range, check out
our [tests](https://github.com/IridescentSoftware/JNApple/tree/main/src/test/java/net/iridescentsoftware/jnapple/test).

**Creating an NSString**

```java
var str = new NSString("Hello, World!");
// You can access this as a Java String if you wish too! (NSString#getJvmString)
```

**Creating an NSURL**

```java
var str = new NSURL("https://iridescentsoftware.net");
// You can access this as a Java URL if you wish too! (NSURL#getJvmURL)
```

**Copying text to the clipboard**

```java
var pasteboard = NSPasteboard.generalPasteboard();
pasteboard.clearContents();
pasteboard.setString("Hello, World!", NSPasteboard.TypeString);
```

**Opening a file picker (NSOpenPanel)**

```java
var panel = NSOpenPanel.openPanel();
panel.setCanChooseFiles(true);

var result = panel.runModal();
if(result == NSAlert.NSModalResponse.OK) {
    NSURL url = panel.getURLs().objectAtIndex(0); // Can also use firstObject()
    System.out.println("First URL: " + url);
}
```
