/*
 * Copyright (c) 2019 airsquared
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package airsquared.JMacNotification.natives;import airsquared.JMacNotification.natives.NSUserNotifications;
import com.sun.jna.Pointer;
import org.junit.Test;

public class NSUserNotificationsTest {

    /**
     * Shows a notification using the static methods in NSUserNotifications
     * Should show a notification with:
     * - Title: "title"
     * - Subtitle: "subtitle"
     * - Body/Informative Text: "body"
     * - Content image: the megaphone image in test/resources/test-image.jpeg
     * And if alert notification type is enabled in Notification settings:
     * - Action button w/ title: "action"
     * - Other button w/ title: "other"
     */
    @Test
    public void showNotif() {
        String title = "title";
        String subtitle = "subtitle";
        String body = "body";
        String contentImagePath = getClass().getResource("test-image.jpeg").getPath();
        boolean hasContentImage = true;
        String actionButtonTitle = "action";
        String otherButtonTitle = "other";

        Pointer notif = NSUserNotifications.create();
        NSUserNotifications.setTitle(notif, title);
        NSUserNotifications.setSubtitle(notif, subtitle);
        NSUserNotifications.setInformativeText(notif, body);
        NSUserNotifications.setContentImagePath(notif, contentImagePath);
        NSUserNotifications.setHasActionButton(notif, hasContentImage);
        NSUserNotifications.setActionButtonTitle(notif, actionButtonTitle);
        NSUserNotifications.setOtherButtonTitle(notif, otherButtonTitle);


        NSUserNotifications.showNotification(notif);
    }

}
