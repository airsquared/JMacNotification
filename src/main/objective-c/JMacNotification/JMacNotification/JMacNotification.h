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

void showNotification(NSUserNotification* notification);

NSUserNotification* newNSUserNotification();

// public values
void setTitle(NSUserNotification* notification, char* title);
void setSubtitle(NSUserNotification* notification, char* subtitle);
void setInformativeText(NSUserNotification* notification, char* informativeText);
void setContentImage(NSUserNotification* notification, char* contentImagePath);
void setHasActionButton(NSUserNotification* notification, bool hasActionButton);
void setActionButtonTitle(NSUserNotification* notification, char* actionButtonTitle);
void setOtherButtonTitle(NSUserNotification* notification, char* otherButtonTitle);

@end

#pragma clang diagnostic pop
