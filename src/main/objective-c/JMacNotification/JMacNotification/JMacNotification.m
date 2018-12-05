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

void showNotification(char* title, char* subtitle, char* informativeText) {
    NSString *titleString = [NSString stringWithUTF8String:title];
    NSString *subtitleString = [NSString stringWithUTF8String:subtitle];
    NSString *informativeTextString = [NSString stringWithUTF8String:informativeText];
    
    NSUserNotification *n = [NSUserNotification new];
    n.title = titleString;
    n.subtitle = subtitleString;
    n.informativeText = informativeTextString;
    [NSUserNotificationCenter.defaultUserNotificationCenter deliverNotification:n];
}

NSUserNotification* newNSUserNotification() {
    return [NSUserNotification new];
}

NSUserNotification* setTitle(NSUserNotification* notification, char* title) {
    notification.title = toNSString(title);
    return notification;
}

NSUserNotification* setSubtitle(NSUserNotification* notification, char* subtitle) {
    notification.title = toNSString(subtitle);
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

// private values

//NSUserNotification *setIdentityImage(NSUserNotification *notification, char *identityImagePath) {
//    [notification setValue:toNSImage(identityImagePath) forKey:@"_identityImage"];
//    return notification;
//}
//
//NSUserNotification *setIdentityImageHasBorder(NSUserNotification *notification, bool identityImageHasBorder) {
//    [notification setValue:@(identityImageHasBorder) forKey:@"_identityImageHasBorder"];
//    return notification;
//}
//
//NSUserNotification *setIgnoresDoNotDisturb(NSUserNotification *notification, bool ignoresDoNotDisturb) {
//    [notification setValue:@(ignoresDoNotDisturb) forKey:@"_ignoresDoNotDisturb"];
//    return notification;
//}
//
//NSUserNotification *setLockscreenOnly(NSUserNotification *notification, bool lockscreenOnly) {
//    [notification setValue:@(lockscreenOnly) forKey:@"_lockscreenOnly"];
//    return notification;
//}
//
//NSUserNotification *setPoofsOnCancel(NSUserNotification *notification, bool poofsOnCancel) {
//    [notification setValue:@(poofsOnCancel) forKey:@"_poofsOnCancel"];
//    return notification;
//}
//
//NSUserNotification *setShowAlternateActionMenu(NSUserNotification *notification, bool poofsOnCancel) {
//    return notification;
//}

@end

#pragma clang diagnostic pop
