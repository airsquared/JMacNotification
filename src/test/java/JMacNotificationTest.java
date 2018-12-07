
import airsquared.JMacNotification.NSUserNotification;
import org.junit.Test;

import org.junit.Assert.*;

public class JMacNotificationTest {
    @Test
    public void showNotificiation() {
        NSUserNotification.showNotification("title", "subtitle", "informative");
    }
}
