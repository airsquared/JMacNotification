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

package airsquared.JMacNotification;

import org.junit.Test;

import java.io.File;
import java.net.URI;

import static org.junit.Assert.assertEquals;

public class NSUserNotificationTest {

    /**
     * Test setting most of the values in {@link NSUserNotification}.
     *
     * Does not show the notification
     */
    @Test
    @SuppressWarnings("ConstantConditions")
    public void values() {
        String title = "title";
        String subtitle = "subtitle";
        String informativeText = "informative text";
        String identifier = "identifier";
        String responsePlaceholder = "response placeholder";
        boolean hasActionButton = true;
        String actionButtonTitle = "action button";
        String otherButtonTitle = "other button";
        boolean hasReplyButton = false;

        NSUserNotification notification = new NSUserNotification();
        notification.setTitle(title);
        assertEquals(title, notification.getTitle());
        notification.setSubtitle(subtitle);
        assertEquals(subtitle, notification.getSubtitle());
        notification.setInformativeText(informativeText);
        assertEquals(informativeText, notification.getInformativeText());
        notification.setIdentifier("identifier");
        assertEquals(identifier, notification.getIdentifier());
        notification.setResponsePlaceholder(responsePlaceholder);
        assertEquals(responsePlaceholder, notification.getResponsePlaceholder());
        notification.setHasActionButton(hasActionButton);
        assertEquals(hasActionButton, notification.getHasActionButton());
        notification.setActionButtonTitle(actionButtonTitle);
        assertEquals(actionButtonTitle, notification.getActionButtonTitle());
        notification.setOtherButtonTitle(otherButtonTitle);
        assertEquals(otherButtonTitle, notification.getOtherButtonTitle());
        notification.setHasReplyButton(hasReplyButton);
        assertEquals(hasReplyButton, notification.getHasReplyButton());
    }

    @Test
    public void showNotif() {
        String title = "title";
        String subtitle = "subtitle";
        String informativeText = "informative text";
        File contentImage = new File(URI.create(getClass().getClassLoader().getResource("test-image.jpeg").toString()));

        NSUserNotification notification = new NSUserNotification();
        notification.setTitle(title);
        notification.setSubtitle(subtitle);
        notification.setInformativeText(informativeText);
        notification.setContentImage(contentImage);

        notification.show();
    }

    @Test
    public void reply() {
        System.out.println("response test not implemented");
    }
}