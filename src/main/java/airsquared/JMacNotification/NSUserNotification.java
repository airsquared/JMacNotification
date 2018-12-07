package airsquared.JMacNotification;

import com.sun.jna.Native;

public class NSUserNotification {

    public static native void showNotification(String title, String subtitle, String informativeText);

    static {
        Native.register("JMacNotification");
    }

}
