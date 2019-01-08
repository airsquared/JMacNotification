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

package airsquared.JMacNotification.natives;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * This class contains static methods relating to Objective-C NSUserNotifications
 * that are directly mapped to native code using JNA.
 *
 * To create a new ObjC NSUserNotification, use {@link #create()}.
 * In any get/set method in this class, the first parameter
 * is always a Pointer to an ObjC NSUserNotification.
 *
 * If a method takes a Pointer as an argument that is not a NSUserNotification,
 * use the methods in {@link NSTypes} to get the appropriate one.
 *
 * Example:
 * <pre>
 * {@code
 *     Pointer notification = NSUserNotification.create();
 *
 *     NSUserNotifications.setTitle(notification, title);
 *     NSUserNotifications.setSubtitle(notification, subtitle);
 *     NSUserNotifications.setInformativeText(notification, body);
 *     NSUserNotifications.setContentImagePath(notif, getClass().getResource("test-image.jpeg").getPath());
 *
 *     NSUserNotifications.showNotification(notification);
 * }
 * </pre>
 *
 * For more examples see the test class {@code airsquared.JMacNotification.natives.NSUserNotificationsTest}
 *
 *
 * See NSUserNotifications.h and NSUserNotifications.m in the source code,
 * located in src/main/objective-c/JMacNotification.
 *
 * @author airsquared
 * @see NSTypes
 */
public class NSUserNotifications {

    /**
     * Creates a new ObjC instance of NSUserNotification using {@code [NSUserNotification new] }.
     * This is a shorthand for {@link #newNSUserNotification()}.
     *
     * @return A {@link Pointer} to a new ObjC NSUserNotification.
     */
    public static Pointer create() {
        return newNSUserNotification();
    }
    public static native Pointer newNSUserNotification();

    /**
     * Shows the notification in the default {@code NSUserNotificationCenter}.
     *
     * The underlying ObjC method call is
     * {@code [NSUserNotificationCenter.defaultUserNotificationCenter deliverNotification:notification] }.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     */
    public static native void showNotification(Pointer notification);

    /* display information */

    public static native void setTitle(Pointer notification, String title);
    public static native String getTitle(Pointer notification);

    public static native void setSubtitle(Pointer notification, String subtitle);
    public static native String getSubtitle(Pointer notification);

    public static native void setInformativeText(Pointer notification, String informativeText);
    public static native String getInformativeText(Pointer notification);

    /**
     * Image shown in the content of the notification.
     *
     * The underlying ObjC method call to get an NSImage from the path is
     * {@code [[NSImage alloc] initWithContentsOfFile:toNSString(path)] }
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param contentImagePath The path to the content image, should include the file extension that identifies
     *                         the type of image data
     */
    public static native void setContentImagePath(Pointer notification, String contentImagePath);
    // currently no way to get the content image path

    /**
     * A string that uniquely identifies a notification.
     *
     * The identifier is unique to a notification. A notification delivered with the same identifier as an
     * existing notification replaces the existing notification rather than causing the display of a new notification.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param identifier A string that uniquely identifies a notification
     */
    public static native void setIdentifier(Pointer notification, String identifier);
    /**
     * A string that uniquely identifies a notification.
     *
     * The identifier is unique to a notification. A notification delivered with the same identifier as an
     * existing notification replaces the existing notification rather than causing the display of a new notification.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return A string that uniquely identifies a notification
     */
    public static native String getIdentifier(Pointer notification);

    public static native void setResponsePlaceholder(Pointer notification, String responsePlaceHolder);
    public static native String getResponsePlaceholder(Pointer notification);

    public static native String getResponse(Pointer notification);

    /* displayed notification buttons */

    /**
     * Only has an effect if notification type is set to "Alerts" in System Preferences.
     */
    public static native void setHasActionButton(Pointer notification, boolean hasActionButton);
    public static native boolean getHasActionButton(Pointer notification);

    public static native void setActionButtonTitle(Pointer notification, String actionButtonTitle);
    public static native String getActionButtonTitle(Pointer notification);

    public static native void setOtherButtonTitle(Pointer notification, String otherButtonTitle);
    public static native String getOtherButtonTitle(Pointer notification);

    /**
     * Only has an effect if notification type is set to "Alerts" in System Preferences.
     */
    public static native void setHasReplyButton(Pointer notification, boolean hasReplyButton);
    public static native boolean getHasReplyButton(Pointer notification);

    /* delivery timing */

    /**
     * Specifies when the notification should be delivered.
     *
     * The delivery date is specified in an absolute time.
     * After a notification is delivered, it may be presented to the user.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param deliveryDate A Pointer to an ObjC NSDate
     */
    public static native void setDeliveryDate(Pointer notification, Pointer deliveryDate);
    /**
     * Specifies when the notification should be delivered.
     *
     * The delivery date is specified in an absolute time.
     * After a notification is delivered, it may be presented to the user.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return A Pointer to an ObjC NSDate
     */
    public static native Pointer getDeliveryDate(Pointer notification);

    /**
     * The date this notification was actually delivered.
     *
     * The notification center will set this value if a notification is put in the scheduled list and the delivery time arrives.
     *
     * If the notification is delivered directly using the {@link #showNotification(Pointer)} function,
     * this value is set to the deliveryDate value. If the deliveryDate value is null this value is set to the current date.
     *
     * This value is used to sort the list of notifications in the user interface.
     *
     * @param notification A Pointer to an ObjCNSUserNotification
     * @return A Pointer to an ObjC NSDate
     */
    public static native Pointer getActualDeliveryDate(Pointer notification);

    /**
     * Specifies the date components that control how often a user notification is repeated.
     *
     * This value may be null if the notification should not repeat.
     * The date component values are relative to the date the notification was delivered.
     *
     * For example, if a notification should repeat every hour, set the hour property of the deliveryRepeatInterval to 1.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param deliveryRepeatInterval A Pointer to an ObjC NSDateComponents
     */
    public static native void setDeliveryRepeatInterval(Pointer notification, Pointer deliveryRepeatInterval);
    /**
     * Specifies the date components that control how often a user notification is repeated.
     *
     * This value may be null if the notification should not repeat.
     * The date component values are relative to the date the notification was delivered.
     *
     * For example, if a notification should repeat every hour, set the hour property of the deliveryRepeatInterval to 1.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return A Pointer to an ObjC NSDateComponents
     */
    public static native Pointer getDeliveryRepeatInterval(Pointer notification);

    /**
     * Specify the time zone to interpret the delivery date in.
     *
     * If this value is null and the user switches time zones, the notification center will adjust the
     * time of presentation to account for the time zone change.
     *
     * If a notification should be delivered at a time in a specific time zone (regardless of whether the user switches time zones),
     * set this value to the specific time zone, for example the current time zone.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param timeZoneIdentifier the time zone ID or identifier(ex: "America/Los_Angeles")
     */
    public static native void setDeliveryTimeZone(Pointer notification, String timeZoneIdentifier);
    /**
     * Specify the time zone to interpret the delivery date in.
     *
     * If this value is null and the user switches time zones, the notification center will adjust the
     * time of presentation to account for the time zone change.
     *
     * If a notification should be delivered at a time in a specific time zone (regardless of whether the user switches time zones),
     * set this value to the specific time zone, for example the current time zone.
     *
     * @param notification A Pointer to an ObjC to a ObjC NSUserNotification
     * @return the delivery time zone ID or identifier(ex: "America/Los_Angeles") of the notification
     */
    public static native String getDeliveryTimeZone(Pointer notification);

    /* delivery information */

    /**
     * Specifies whether the user notification has been presented.
     *
     * In some cases, for example when your application is frontmost,
     * the notification center may decide not to actually present a delivered notification.
     * In that case, the value of this is false.
     * It is set to true if the notification was presented according to user preferences.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return whether the user notification has been presented
     */
    public static native boolean getIsPresented(Pointer notification);

    /**
     * Specifies whether the remote was generated by a push notification.
     *
     * If this is true then the user notification was generated by a push notification (that is, remotely);
     * if false it was generated locally.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return whether the remote was generated by a push notification
     */
    public static native boolean getIsRemote(Pointer notification);

    public static native void setSoundName(Pointer notification, String soundName);
    public static native String getSoundName(Pointer notification);


    /* user notification activation method */

    /**
     * Specifies what caused a user notification to occur.
     *
     * This specifies why the user notification was sent to to the NSUserNotificationCenterDelegate method
     * {@code didActivateNotification}.
     * The supported values are described in {@link #NSUserNotificationActivationTypes}.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return what caused a user notification to occur, one of {@link #NSUserNotificationActivationTypes}
     */
    public static native String getActivationType(Pointer notification);

    /**
     * An additional action selected by the user.
     *
     * This specifies an additional action selected by the user when the user notification is sent to to the
     * NSUserNotificationCenterDelegate method {@code didActivateNotification}.
     * The supported values are described in {@link #NSUserNotificationActivationTypes}.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return an additional action selected by the user, a pointer to an ObjC NSUserNotificationAction
     */
    public static native Pointer getAdditionalActivationAction(Pointer notification);

    /**
     * The actions that can be taken on a notification in addition to the default action.
     *
     * This array contains NSUserNotificationAction objects that describe the different actions
     * for a notification in addition to the default action described by actionButtonTitle.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @param additionalActionsArray a pointer to an ObjC NSArray containing NSUserNotificationAction objects
     */
    public static native void setAdditionalActionsArray(Pointer notification, Pointer additionalActionsArray);
    /**
     * The actions that can be taken on a notification in addition to the default action.
     *
     * This array contains NSUserNotificationAction objects that describe the different actions
     * for a notification in addition to the default action described by actionButtonTitle.
     *
     * @param notification A Pointer to an ObjC NSUserNotification
     * @return A pointer to an ObjC NSArray containing NSUserNotificationAction objects
     */
    public static native Pointer getAdditionalActionsArray(Pointer notification);


    /* constants */

    /**
     * This array contains strings that describe how the user notification was activated.
     *
     * The values in this array are:
     *  - NSUserNotificationActivationTypeNone: The user did not interact with the notification alert.
     *  - NSUserNotificationActivationTypeContentsClicked: The user clicked on the contents of the notification alert.
     *  - NSUserNotificationActivationTypeActionButtonClicked: The user clicked on the action button of the notification alert.
     *  - NSUserNotificationActivationTypeReplied: The user replied to the notification.
     *  - NSUserNotificationActivationTypeAdditionalActionClicked: The user clicked on the additional action button of the notification alert.
     */
    public static final String[] NSUserNotificationActivationTypes = new String[]{
            "NSUserNotificationActivationTypeNone",
            "NSUserNotificationActivationTypeContentsClicked",
            "NSUserNotificationActivationTypeActionButtonClicked",
            "NSUserNotificationActivationTypeReplied",
            "NSUserNotificationActivationTypeAdditionalActionClicked"
    };

    public static native String getNSUserNotificationDefaultSoundName();


    static {
        Native.register("JMacNotification");
    }

    /**
     * The class NSUserNotifications cannot be instantiated; all methods are static.
     *
     * Use {@link #create()}
     */
    private NSUserNotifications() {
    }

}
