
import airsquared.JMacNotification.NSUserNotification;
import com.sun.jna.Pointer;
import org.junit.Test;

import org.junit.Assert.*;

public class JMacNotificationTest {

    @Test
    public void showNotification() {
        Pointer notif = NSUserNotification.newNSUserNotification();
        NSUserNotification.setTitle(notif, "title");
        NSUserNotification.setSubtitle(notif, "subtitle");
        NSUserNotification.setInformativeText(notif, "informative");
        NSUserNotification.showNotification(notif);
    }
}
