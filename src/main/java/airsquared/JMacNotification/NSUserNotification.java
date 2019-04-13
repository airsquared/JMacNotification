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
import airsquared.JMacNotification.natives.NSUserNotifications;
import com.sun.jna.Pointer;

import java.io.File;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author airsquared
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class NSUserNotification implements NSObject {

    Pointer pointer;

    public NSUserNotification() {
        pointer = NSUserNotifications.create();
    }

    public NSUserNotification(Pointer p) {
        pointer = p;
    }

    public NSUserNotification(String title, String subtitle, String informativeText) {
        setTitle(title);
        setTitle(subtitle);
        setInformativeText(informativeText);
    }

    // getters and setters

    public String getTitle() {
        return NSUserNotifications.getTitle(pointer);
    }
    public void setTitle(String title) {
        NSUserNotifications.setTitle(pointer, title);
    }

    public String getSubtitle() {
        return NSUserNotifications.getSubtitle(pointer);
    }
    public void setSubtitle(String subtitle) {
        NSUserNotifications.setSubtitle(pointer, subtitle);
    }

    public String getInformativeText() {
        return NSUserNotifications.getInformativeText(pointer);
    }
    public void setInformativeText(String informativeText) {
        NSUserNotifications.setInformativeText(pointer, informativeText);
    }

    // currently still need to implement way to get the content image
    public void setContentImage(File contentImage) {
        NSUserNotifications.setContentImagePath(pointer, contentImage.getAbsolutePath());
    }

    public String getIdentifier() {
        return NSUserNotifications.getIdentifier(pointer);
    }
    public void setIdentifier(String identifier) {
        NSUserNotifications.setIdentifier(pointer, identifier);
    }

    public String getResponse() {
        return NSUserNotifications.getResponse(pointer);
    }

    public String getResponsePlaceholder() {
        return NSUserNotifications.getResponsePlaceholder(pointer);
    }
    public void setResponsePlaceholder(String responsePlaceholder) {
        NSUserNotifications.setResponsePlaceholder(pointer, responsePlaceholder);
    }

    public boolean getHasActionButton() {
        return NSUserNotifications.getHasActionButton(pointer);
    }
    public void setHasActionButton(boolean hasActionButton) {
        NSUserNotifications.setHasActionButton(pointer, hasActionButton);
    }

    public String getActionButtonTitle() {
        return NSUserNotifications.getActionButtonTitle(pointer);
    }
    public void setActionButtonTitle(String actionButtonTitle) {
        NSUserNotifications.setActionButtonTitle(pointer, actionButtonTitle);
    }

    public String getOtherButtonTitle() {
        return NSUserNotifications.getOtherButtonTitle(pointer);
    }
    public void setOtherButtonTitle(String otherButtonTitle) {
        NSUserNotifications.setOtherButtonTitle(pointer, otherButtonTitle);
    }

    public boolean getHasReplyButton() {
        return NSUserNotifications.getHasReplyButton(pointer);
    }
    public void setHasReplyButton(boolean hasReplyButton) {
        NSUserNotifications.setHasReplyButton(pointer, hasReplyButton);
    }

    public LocalDateTime getDeliveryDate() {
        return new NSDateComponents(NSTypes.toDateComponents(NSUserNotifications.getDeliveryDate(pointer))).toLocalDateTime();
    }
    public void setDeliveryDate(LocalDateTime deliveryDate) {
        NSUserNotifications.setDeliveryDate(pointer, NSDateComponents.fromLocalDateTime(deliveryDate).toNSDate());
    }

    public LocalDateTime getActualDeliveryDate() {
        return new NSDateComponents(NSTypes.toDateComponents(NSUserNotifications.getActualDeliveryDate(pointer))).toLocalDateTime();
    }

    public NSDateComponents getDeliveryRepeatInterval() {
        return new NSDateComponents(NSUserNotifications.getDeliveryRepeatInterval(pointer));
    }
    public void setDeliveryRepeatInterval(NSDateComponents deliveryRepeatInterval) {
        NSUserNotifications.setDeliveryRepeatInterval(pointer, deliveryRepeatInterval.getPointer());
    }

    public TimeZone getDeliveryTimeZone() {
        return TimeZone.getTimeZone(NSUserNotifications.getDeliveryTimeZone(pointer));
    }
    public void setDeliveryTimeZone(TimeZone deliveryTimeZone) {
        NSUserNotifications.setDeliveryTimeZone(pointer, deliveryTimeZone.getID()); // not sure if getID returns the right value
    }

    public boolean isPresented() {
        return NSUserNotifications.getIsPresented(pointer);
    }

    public boolean isRemote() {
        return NSUserNotifications.getIsRemote(pointer);
    }

    public String getSoundName() {
        return NSUserNotifications.getSoundName(pointer);
    }
    public void setSoundName(String soundName) {
        NSUserNotifications.setSoundName(pointer, soundName);
    }

    public NSUserNotificationActivationType getActivationType() {
        return NSUserNotificationActivationType.valueOf(NSUserNotifications.getActivationType(pointer));
    }

    public NSUserNotificationAction getAdditionalActivationAction() {
        return new NSUserNotificationAction(NSUserNotifications.getAdditionalActivationAction(pointer));
    }

    public NSArray getAdditionalActions() {
        return new NSArray(NSUserNotifications.getAdditionalActionsArray(pointer));
    }
    public void setAdditionalActions(NSArray additionalActions) {
        NSUserNotifications.setAdditionalActionsArray(pointer, additionalActions.getPointer());
    }

    public void show() {
        NSUserNotifications.showNotification(pointer);
    }

    public enum NSUserNotificationActivationType {
        /**
         * The user did not interact with the notification alert.
         */
        NSUserNotificationActivationTypeNone,
        /**
         * The user clicked on the contents of the notification alert.
         */
        NSUserNotificationActivationTypeContentsClicked,
        /**
         * The user clicked on the action button of the notification alert.
         */
        NSUserNotificationActivationTypeActionButtonClicked,
        /**
         * The user replied to the notification.
         */
        NSUserNotificationActivationTypeReplied,
        /**
         * The user clicked on the additional action button of the notification alert.
         */
        NSUserNotificationActivationTypeAdditionalActionClicked;

        public Pointer toNative() {
            return NSTypes.toNSUserNotificationActivationType(toString());
        }

        public static NSUserNotificationActivationType fromNative(Pointer objCNSUserNotificationActivationType) {
            return valueOf(NSTypes.toStringNSUserNotificationActivation(objCNSUserNotificationActivationType));
        }
    }

    public static String getDefaultSoundName() {
        return NSUserNotifications.getNSUserNotificationDefaultSoundName();
    }

    @Override
    public Pointer getPointer() {
        return pointer;
    }

    @Override
    public String nativeType() { return "NSUserNotification"; }

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
