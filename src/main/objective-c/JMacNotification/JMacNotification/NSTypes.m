//
// Created by Rishi Raja on 2018-12-28.
// Copyright (c) 2018 airsquared. All rights reserved.
//

#import <AppKit/AppKit.h>
#import "NSTypes.h"


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
@implementation NSTypes

/** convertion functions **/

NSString *toNSString(char *string) {
    return [NSString stringWithUTF8String:string];
}

char *toCString(NSString *string) {
    return string == nil ? NULL : strdup([string UTF8String]); // make sure strdup isn't called on nil
}

NSImage *toNSImage(char *path) {
    return [[NSImage alloc] initWithContentsOfFile:toNSString(path)];
}


/** NSDate/NSDateComponents functions */

NSDateComponents *newNSDateComponents() {
    return [NSDateComponents new];
}

void setDay(NSDateComponents *dateComponents, int day) {
    dateComponents.day = day;
}
int getDay(NSDateComponents *dateComponents) {
    return (int) dateComponents.day;
}

void setMonth(NSDateComponents *dateComponents, int month) {
    dateComponents.month = month;
}
int getMonth(NSDateComponents *dateComponents) {
    return (int) dateComponents.month;
}

void setYear(NSDateComponents *dateComponents, int year) {
    dateComponents.year = year;
}
int getYear(NSDateComponents *dateComponents) {
    return (int) dateComponents.year;
}

void setHour(NSDateComponents *dateComponents, int hour) {
    dateComponents.hour = hour;
}
int getHour(NSDateComponents *dateComponents) {
    return (int) dateComponents.hour;
}

void setMinute(NSDateComponents *dateComponents, int minute) {
    dateComponents.minute = minute;
}
int getMinute(NSDateComponents *dateComponents) {
    return (int) dateComponents.minute;
}

void setSecond(NSDateComponents *dateComponents, int second) {
    dateComponents.second = second;
}
int getSecond(NSDateComponents *dateComponents) {
    return (int) dateComponents.second;
}

// uses [NSCalendar currentCalendar]
NSDate *toNSDate(NSDateComponents *dateComponents) {
    return [[NSCalendar currentCalendar] dateFromComponents:dateComponents];
}


/** NSUserNotificationAction functions */

NSUserNotificationAction *createNSUserNotificationAction(char *identifier, char *title) {
    return [NSUserNotificationAction actionWithIdentifier:toNSString(identifier) title:toNSString(title)];
}

char *getNSUserNotificationActionIdentifier(NSUserNotificationAction *action) {
    return toCString(action.identifier);
}

char *getNSUserNotificationActionTitle(NSUserNotificationAction *action) {
    return toCString(action.title);
}


/** NSArray/NSMutableArray functions */

NSArray *newNSMutableArray() {
    return [NSMutableArray array];
}

/* querying an array */

bool containsObject(NSArray *array, NSObject *object) {
    return [array containsObject:object];
}

int count(NSArray *array) {
    return (int) array.count;
}

NSObject* objectAtIndex(NSArray *array, int index) {
    return array[(NSUInteger) index];
}

/* finding objects in an array */

int indexOfObject(NSArray *array, NSObject *object) {
    return (int) [array indexOfObject:object];
}

/* adding/inserting objects */

void addObject(NSMutableArray *array, NSObject* object) {
    [array addObject:object];
}

void insertObjectAtIndex(NSMutableArray *array, NSObject *object, int index) {
    [array insertObject:object atIndex:(NSUInteger) index];
}

/* removing objects */

void removeAllObjects(NSMutableArray *array) {
    [array removeAllObjects];
}

void removeObject(NSMutableArray *array, NSObject* object) {
    [array removeObject:object];
}

void removeObjectAtIndex(NSMutableArray *array, int index) {
    [array removeObjectAtIndex:index];
}

void removeObjectIdenticalTo(NSMutableArray *array, NSObject* object) {
    [array removeObjectIdenticalTo:object];
}

/* replacing objects */

void replaceObjectAtIndex(NSMutableArray *array, int index, NSObject* withObject) {
    [array replaceObjectAtIndex:index withObject:withObject];
}

void exchangeObjectAtIndex(NSMutableArray *array, int object1Index, int object2Index) {
    [array exchangeObjectAtIndex:object1Index withObjectAtIndex:object2Index];
}


@end
#pragma clang diagnostic pop