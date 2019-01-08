//
//  NSUserNotifications.m
//  NSUserNotifications
//
//  Created by airsquared on 11/12/18.
//  Copyright © 2018 airsquared. All rights reserved.
//


/*
 *
 * SEE THE JAVADOC FOR airsquared.NSUserNotification
 * FOR INFORMATION ON HOW THE FUNCTIONS WORK
 *
 */

#import <AppKit/AppKit.h>
#import "NSUserNotifications.h"
#include "NSUserNotifications.h"
#import "NSTypes.h"


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"

@implementation NSUserNotifications

/** NSUserNotification functions **/

NSUserNotification *newNSUserNotification() {
    return [NSUserNotification new];
}

void showNotification(NSUserNotification *notification) {
    [NSUserNotificationCenter.defaultUserNotificationCenter deliverNotification:notification];
}


/* display information */

void setTitle(NSUserNotification *notification, char *title) {
    notification.title = toNSString(title);
}
char *getTitle(NSUserNotification *notification) {
    return toCString(notification.title);
}

void setSubtitle(NSUserNotification *notification, char *subtitle) {
    notification.subtitle = toNSString(subtitle);
}
char *getSubtitle(NSUserNotification *notification) {
    return toCString(notification.subtitle);
}

void setInformativeText(NSUserNotification *notification, char *informativeText) {
    notification.informativeText = toNSString(informativeText);
}
char *getInformativeText(NSUserNotification *notification) {
    return toCString(notification.informativeText);
}

void setContentImagePath(NSUserNotification *notification, char *contentImagePath) {
    notification.contentImage = toNSImage(contentImagePath);
}
// no way to get the content image path

void setIdentifier(NSUserNotification *notification, char *identifier) {
    notification.identifier = toNSString(identifier);
}
char *getIdentifier(NSUserNotification *notification) {
    return toCString(notification.identifier);
}

void setResponsePlaceholder(NSUserNotification *notification, char *responsePlaceHolder) {
    notification.responsePlaceholder = toNSString(responsePlaceHolder);
}
char *getResponsePlaceholder(NSUserNotification *notification) {
    return toCString(notification.responsePlaceholder);
}

char *getResponse(NSUserNotification *notification) {
    return toCString([notification.response string]);
}


/* displayed notification buttons */

void setHasActionButton(NSUserNotification *notification, bool hasActionButton) {
    notification.hasActionButton = hasActionButton;
}
bool getHasActionButton(NSUserNotification *notification) {
    return notification.hasActionButton;
}

void setActionButtonTitle(NSUserNotification *notification, char *actionButtonTitle) {
    notification.actionButtonTitle = toNSString(actionButtonTitle);
}
char *getActionButtonTitle(NSUserNotification *notification) {
    return toCString(notification.actionButtonTitle);
}

void setOtherButtonTitle(NSUserNotification *notification, char *otherButtonTitle) {
    notification.otherButtonTitle = toNSString(otherButtonTitle);
}
char *getOtherButtonTitle(NSUserNotification *notification) {
    return toCString(notification.otherButtonTitle);
}

void setHasReplyButton(NSUserNotification *notification, bool hasReplyButton) {
    notification.hasReplyButton = hasReplyButton;
}
bool getHasReplyButton(NSUserNotification *notification) {
    return notification.hasReplyButton;
}


/* delivery timing */

void setDeliveryDate(NSUserNotification *notification, NSDate *deliveryDate) {
    notification.deliveryDate = deliveryDate;
}
NSDate *getDeliveryDate(NSUserNotification *notification) {
    return notification.deliveryDate;
}

NSDate *getActualDeliveryDate(NSUserNotification *notification) {
    return notification.actualDeliveryDate;
}

void setDeliveryRepeatInterval(NSUserNotification *notification, NSDateComponents *deliveryRepeatInterval) {
    notification.deliveryRepeatInterval = deliveryRepeatInterval;
}
NSDateComponents *getDeliveryRepeatInterval(NSUserNotification *notification) {
    return notification.deliveryRepeatInterval;
}

// timeZoneIdentifer is the time zone ID or identifier(ex: "America/Los_Angeles")
void setDeliveryTimeZone(NSUserNotification *notification, char *timeZoneIdentifier) {
    notification.deliveryTimeZone = [NSTimeZone timeZoneWithName:toNSString(timeZoneIdentifier)];
}
char *getDeliveryTimeZone(NSUserNotification *notification) {
    return toCString(notification.deliveryTimeZone.name);
}


/* delivery information */

bool getIsPresented(NSUserNotification *notification) {
    return notification.isPresented;
}

bool getIsRemote(NSUserNotification *notification) {
    return notification.isRemote;
}

void setSoundName(NSUserNotification *notification, char *soundName) {
    notification.soundName = toNSString(soundName);
}
char *getSoundName(NSUserNotification *notification) {
    return toCString(notification.soundName);
}


/* user notification activation method */

char *getActivationType(NSUserNotification *notification) {
    return NSUserNotificationActivationTypeToString[notification.activationType];
}

NSUserNotificationAction *getAdditionalActivationAction(NSUserNotification *notification) {
    return notification.additionalActivationAction;
}

void setAdditionalActionsArray(NSUserNotification *notification, NSArray *additionalActionsArray) {
   notification.additionalActions = additionalActionsArray;
}
NSArray<NSUserNotificationAction*> *getAdditionalActionsArray(NSUserNotification *notification) {
    return notification.additionalActions;
}


/* constants */
char *const NSUserNotificationActivationTypeToString[] = {
        [NSUserNotificationActivationTypeNone] = "NSUserNotificationActivationTypeNone",
        [NSUserNotificationActivationTypeContentsClicked]  = "NSUserNotificationActivationTypeContentsClicked",
        [NSUserNotificationActivationTypeActionButtonClicked] = "NSUserNotificationActivationTypeActionButtonClicked",
        [NSUserNotificationActivationTypeReplied] = "NSUserNotificationActivationTypeReplied",
        [NSUserNotificationActivationTypeAdditionalActionClicked] = "NSUserNotificationActivationTypeAdditionalActionClicked"
};

char *getNSUserNotificationDefaultSoundName() {
    return toCString(NSUserNotificationDefaultSoundName);
}


@end

#pragma clang diagnostic pop
