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

/**
 * @author airsquared
 */
public class NSUserNotificationAction implements NSObject {

    private Pointer pointer;

    public NSUserNotificationAction(String title, String identifier) {
        pointer = NSTypes.createNSUserNotificationAction(identifier, title);
    }

    public NSUserNotificationAction(Pointer p) {
        pointer = p;
    }

    public String getTitle() {
        return NSTypes.getNSUserNotificationActionTitle(pointer);
    }

    public String getIdentifier() {
        return NSTypes.getNSUserNotificationActionIdentifier(pointer);
    }

    @Override
    public Pointer getPointer() {
        return pointer;
    }

    @Override
    public String nativeType() {
        return "NSUserNotificationAction";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pointer) {
            return NSTypes.isEqual(pointer, (Pointer) obj);
        }
        if (obj instanceof NSObject) {
            return NSTypes.isEqual(pointer, ((NSObject) obj).getPointer());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return NSTypes.hash(pointer);
    }
}
