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

NSUserNotification* setTitle(NSUserNotification* notification, char* title) {
    notification.title = toNSString(title);
    return notification;
}

NSUserNotification* setSubtitle(NSUserNotification* notification, char* subtitle) {
    notification.subtitle = toNSString(subtitle);
    return notification;
}

NSUserNotification *setInformativeText(NSUserNotification *notification, char *informativeText) {
    notification.informativeText = toNSString(informativeText);
    return notification;
}

NSUserNotification *setContentImage(NSUserNotification *notification, char *contentImagePath) {
    notification.contentImage = toNSImage(contentImagePath);
    return notification;
}

NSUserNotification *setHasActionButton(NSUserNotification *notification, bool hasActionButton) {
    notification.hasActionButton = hasActionButton;
    return notification;
}

NSUserNotification *setActionButtonTitle(NSUserNotification *notification, char *actionButtonTitle) {
    notification.actionButtonTitle = toNSString(actionButtonTitle);
    return notification;
}

NSUserNotification *setOtherButtonTitle(NSUserNotification *notification, char *otherButtonTitle) {
    notification.otherButtonTitle = toNSString(otherButtonTitle);
    return notification;
}

@end

#pragma clang diagnostic pop
