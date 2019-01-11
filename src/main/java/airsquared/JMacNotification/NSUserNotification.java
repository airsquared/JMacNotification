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
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author airsquared
 */
public class NSUserNotification {

    // Display Information

    private String title;
    private String subtitle;
    private String informativeText;
    private File contentImage;
    private String identifier;
    // String response
    private String responsePlaceholder;

    // Displayed Notification Buttons

    private boolean hasActionButton;
    private String actionButtonTitle;
    private String otherButtonTitle;
    private boolean hasReplyButton;

    // Delivery Timing

    private Date deliveryDate;
    // Date actualDeliveryDate
    private NSDateComponents deliveryRepeatInterval;
    private TimeZone deliveryTimeZone;

    // Delivery Information

    // boolean presented
    // boolean remote
    private String soundName;

    // User Notification Activation Method

    private NSUserNotificationActivationType activationType;
    // NSUserNotificationAction additionalActivationAction;
    private ArrayList<NSUserNotificationAction> additionalActions;

    // getters and setters

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getInformativeText() {
        return informativeText;
    }
    public void setInformativeText(String informativeText) {
        this.informativeText = informativeText;
    }

    public File getContentImage() {
        return contentImage;
    }
    public void setContentImage(File contentImage) {
        this.contentImage = contentImage;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getResponsePlaceholder() {
        return responsePlaceholder;
    }
    public void setResponsePlaceholder(String responsePlaceholder) {
        this.responsePlaceholder = responsePlaceholder;
    }

    public boolean isHasActionButton() {
        return hasActionButton;
    }
    public void setHasActionButton(boolean hasActionButton) {
        this.hasActionButton = hasActionButton;
    }

    public String getActionButtonTitle() {
        return actionButtonTitle;
    }
    public void setActionButtonTitle(String actionButtonTitle) {
        this.actionButtonTitle = actionButtonTitle;
    }

    public String getOtherButtonTitle() {
        return otherButtonTitle;
    }
    public void setOtherButtonTitle(String otherButtonTitle) {
        this.otherButtonTitle = otherButtonTitle;
    }

    public boolean isHasReplyButton() {
        return hasReplyButton;
    }
    public void setHasReplyButton(boolean hasReplyButton) {
        this.hasReplyButton = hasReplyButton;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public NSDateComponents getDeliveryRepeatInterval() {
        return deliveryRepeatInterval;
    }
    public void setDeliveryRepeatInterval(NSDateComponents deliveryRepeatInterval) {
        this.deliveryRepeatInterval = deliveryRepeatInterval;
    }

    public TimeZone getDeliveryTimeZone() {
        return deliveryTimeZone;
    }
    public void setDeliveryTimeZone(TimeZone deliveryTimeZone) {
        this.deliveryTimeZone = deliveryTimeZone;
    }

    public String getSoundName() {
        return soundName;
    }
    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public NSUserNotificationActivationType getActivationType() {
        return activationType;
    }
    public void setActivationType(NSUserNotificationActivationType activationType) {
        this.activationType = activationType;
    }

    public ArrayList<NSUserNotificationAction> getAdditionalActions() {
        return additionalActions;
    }
    public void setAdditionalActions(ArrayList<NSUserNotificationAction> additionalActions) {
        this.additionalActions = additionalActions;
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

}
