package net.iridescentsoftware.jnapple.test.foundation;

import net.iridescentsoftware.jnapple.foundation.NSURL;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * Test class for {@link NSURL}.
 */
public class NSURLTest {
    /**
     * Test method for {@link NSURL#NSURL(String)}.
     * Ensures that an exception is thrown when the URL is invalid
     */
    @Test
    void testEmptyURL() {
        var url = new NSURL("");
        assert !url.isNull();
    }

    /**
     * Test method for {@link NSURL#NSURL(String)}.
     * Ensures that the URL created by the system is the same as one that would be created by Java
     */
    @Test
    void testValidURL() throws MalformedURLException {
        var url = new NSURL("https://google.com");
        assert Objects.equals(url.getJvmURL(), new URL("https://google.com"));
    }
}
