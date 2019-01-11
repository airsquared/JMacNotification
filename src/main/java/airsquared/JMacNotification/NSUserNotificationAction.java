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

import airsquared.JMacNotification.natives.NSTypes;
import com.sun.jna.Pointer;

public class NSUserNotificationAction {

    private String title;
    private String identifier;

    public NSUserNotificationAction(String title, String identifier) {
        this.title = title;
        this.identifier = identifier;
    }

    public NSUserNotificationAction(Pointer objCNSUserNotificationAction) {
        this.title = NSTypes.getNSUserNotificationActionTitle(objCNSUserNotificationAction);
        this.identifier = NSTypes.getNSUserNotificationActionIdentifier(objCNSUserNotificationAction);
    }

    public static NSUserNotificationAction fromNative(Pointer objCNSUserNotificationAction) {
        return new NSUserNotificationAction(objCNSUserNotificationAction);
    }

    public void toNative() {
        NSTypes.createNSUserNotificationAction(title, identifier);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
