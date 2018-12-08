//
//  JMacNotification.m
//  JMacNotification
//
//  Created by airsquared on 11/12/18.
//  Copyright © 2018 airsquared. All rights reserved.
//

#import <AppKit/AppKit.h>
#import "JMacNotification.h"
#include "JMacNotification.h"


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
@implementation JMacNotification

NSString *toNSString(char* string) {
    return [NSString stringWithUTF8String:string];
}

NSImage *toNSImage(char* path) {
    return [[NSImage alloc] initWithContentsOfFile: toNSString(path)];
}

void showNotification(NSUserNotification* notification) {
    [NSUserNotificationCenter.defaultUserNotificationCenter deliverNotification:notification];
}

NSUserNotification* newNSUserNotification() {
    return [NSUserNotification new];
}

void setTitle(NSUserNotification* notification, char* title) {
    notification.title = toNSString(title);
}

void setSubtitle(NSUserNotification* notification, char* subtitle) {
    notification.subtitle = toNSString(subtitle);
}

void setInformativeText(NSUserNotification *notification, char *informativeText) {
    notification.informativeText = toNSString(informativeText);
}

void setContentImage(NSUserNotification *notification, char *contentImagePath) {
    notification.contentImage = toNSImage(contentImagePath);
}

void setHasActionButton(NSUserNotification *notification, bool hasActionButton) {
    notification.hasActionButton = hasActionButton;
}

void setActionButtonTitle(NSUserNotification *notification, char *actionButtonTitle) {
    notification.actionButtonTitle = toNSString(actionButtonTitle);
}

void setOtherButtonTitle(NSUserNotification *notification, char *otherButtonTitle) {
    notification.otherButtonTitle = toNSString(otherButtonTitle);
}

@end

#pragma clang diagnostic pop
