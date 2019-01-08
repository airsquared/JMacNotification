//
//  NSUserNotifications.h
//  NSUserNotifications
//
//  Created by airsquared on 11/12/18.
//  Copyright © 2018 airsquared. All rights reserved.
//


/*
 *
 * SEE THE JAVADOC FOR airsquared.NSUserNotification
 *
 */

#import <Foundation/Foundation.h>

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"

@interface NSUserNotifications : NSObject

/** NSUserNotification functions */

NSUserNotification *newNSUserNotification();

void showNotification(NSUserNotification *notification);


/* display information */

void setTitle(NSUserNotification *notification, char *title);
char *getTitle(NSUserNotification *notification);

void setSubtitle(NSUserNotification *notification, char *subtitle);
char *getSubtitle(NSUserNotification *notification);

void setInformativeText(NSUserNotification *notification, char *informativeText);
char *getInformativeText(NSUserNotification *notification);

void setContentImagePath(NSUserNotification *notification, char *contentImagePath);
// no way to get the content image path

void setIdentifier(NSUserNotification *notification, char *identifier);
char *getIdentifier(NSUserNotification *notification);

void setResponsePlaceholder(NSUserNotification *notification, char *responsePlaceHolder);
char *getResponsePlaceholder(NSUserNotification *notification);

char *getResponse(NSUserNotification *notification);


/* displayed notification buttons */

void setHasActionButton(NSUserNotification *notification, bool hasActionButton);
bool getHasActionButton(NSUserNotification *notification);

void setActionButtonTitle(NSUserNotification *notification, char *actionButtonTitle);
char *getActionButtonTitle(NSUserNotification *notification);

void setOtherButtonTitle(NSUserNotification *notification, char *otherButtonTitle);
char *getOtherButtonTitle(NSUserNotification *notification);

void setHasReplyButton(NSUserNotification *notification, bool hasReplyButton);
bool getHasReplyButton(NSUserNotification *notification);


/* delivery timing */

void setDeliveryDate(NSUserNotification *notification, NSDate *deliveryDate);
NSDate *getDeliveryDate(NSUserNotification *notification);
NSDate *getActualDeliveryDate(NSUserNotification *notification);

void setDeliveryRepeatInterval(NSUserNotification *notification, NSDateComponents *deliveryRepeatInterval);
NSDateComponents *getDeliveryRepeatInterval(NSUserNotification *notification);

// timeZoneIdentifer is the time zone ID or identifier(ex: "America/Los_Angeles")
void setDeliveryTimeZone(NSUserNotification *notification, char *timeZoneIdentifier);
char *getDeliveryTimeZone(NSUserNotification *notification);


/* delivery information */

bool getIsPresented(NSUserNotification *notification);

bool getIsRemote(NSUserNotification *notification);

void setSoundName(NSUserNotification *notification, char *soundName);
char *getSoundName(NSUserNotification *notification);


/* user notification activation method */

char *getActivationType(NSUserNotification *notification);

NSUserNotificationAction *getAdditionalActivationAction(NSUserNotification *notification);

void setAdditionalActionsArray(NSUserNotification *notification, NSArray *additionalActionsArray);
NSArray<NSUserNotificationAction*> *getAdditionalActionsArray(NSUserNotification *notification);


/* constants */

// see NSUserNotifications.m for NSUserNotificationActivationType

char *getNSUserNotificationDefaultSoundName();


@end

#pragma clang diagnostic pop
