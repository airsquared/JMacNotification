//
//  JMacNotification.h
//  JMacNotification
//
//  Created by airsquared on 11/12/18.
//  Copyright © 2018 airsquared. All rights reserved.
//

#import <Foundation/Foundation.h>

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
@interface JMacNotification : NSObject

void showNotification(char* title, char* subtitle, char* informativeText);

NSUserNotification* newNSUserNotification();

// public values
NSUserNotification* setTitle(NSUserNotification* notification, char* title);
NSUserNotification* setSubtitle(NSUserNotification* notification, char* subtitle);
NSUserNotification* setInformativeText(NSUserNotification* notification, char* informativeText);
NSUserNotification* setContentImage(NSUserNotification* notification, char* contentImagePath);
NSUserNotification* setHasActionButton(NSUserNotification* notification, bool hasActionButton);
NSUserNotification* setActionButtonTitle(NSUserNotification* notification, char* actionButtonTitle);
NSUserNotification* setOtherButtonTitle(NSUserNotification* notification, char* otherButtonTitle);

// private values

//NSUserNotification* setIdentityImage(NSUserNotification* notification, char* identityImagePath);
//NSUserNotification* setidentityImageHasBorder(NSUserNotification* notification, bool hasIdentityImageBorder);
//NSUserNotification* setIgnoresDoNotDisturb(NSUserNotification* notification, bool ignoresDoNotDisturb);
//NSUserNotification* setLockscreenOnly(NSUserNotification* notification, bool lockscreenOnly);
//NSUserNotification* setPoofsOnCancel(NSUserNotification* notification, bool poofsOnCancel);
//NSUserNotification* setShowAlternateActionMenu(NSUserNotification* notification, bool poofsOnCancel);


@end

#pragma clang diagnostic pop
