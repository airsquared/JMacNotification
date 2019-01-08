//
// Created by airsquared on 2018-12-28.
// Copyright (c) 2018 airsquared. All rights reserved.
//

#import <Foundation/Foundation.h>


#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wdeprecated-declarations"
@interface NSTypes : NSObject

/** basic convertion functions **/

NSString *toNSString(char *string);

char *toCString(NSString *string);

NSImage *toNSImage(char *path);


/** NSDate/NSDateComponents functions */

NSDateComponents *newNSDateComponents();

void setDay(NSDateComponents *dateComponents, int day);
int getDay(NSDateComponents *dateComponents);

void setMonth(NSDateComponents *dateComponents, int month);
int getMonth(NSDateComponents *dateComponents);

void setYear(NSDateComponents *dateComponents, int year);
int getYear(NSDateComponents *dateComponents);

void setHour(NSDateComponents *dateComponents, int hour);
int getHour(NSDateComponents *dateComponents);

void setMinute(NSDateComponents *dateComponents, int minute);
int getMinute(NSDateComponents *dateComponents);

void setSecond(NSDateComponents *dateComponents, int second);
int getSecond(NSDateComponents *dateComponents);

// uses [NSCalendar currentCalendar]
NSDate *toNSDate(NSDateComponents *dateComponents);


/** NSUserNotificationAction functions */

NSUserNotificationAction *createNSUserNotificationAction(char *identifier, char *title);

char *getNSUserNotificationActionIdentifier(NSUserNotificationAction *action);

char *getNSUserNotificationActionTitle(NSUserNotificationAction *action);


/** NSArray/NSMutableArray functions */

NSArray *newNSMutableArray();

/* querying an array */

bool containsObject(NSArray *array, NSObject *object);

int count(NSArray *array);

NSObject* objectAtIndex(NSArray *array, int index);

/* finding objects in an array */

int indexOfObject(NSArray *array, NSObject *object);

/* adding/inserting objects */

void addObject(NSMutableArray *array, NSObject *object);

void insertObjectAtIndex(NSMutableArray *array, NSObject *object, int index);

/* removing objects */

void removeAllObjects(NSMutableArray *array);

void removeObject(NSMutableArray *array, NSObject *object);

void removeObjectAtIndex(NSMutableArray *array, int index);

void removeObjectIdenticalTo(NSMutableArray *array, NSObject *object);

/* replacing objects */

void replaceObjectAtIndex(NSMutableArray *array, int index, NSObject *withObject);

void exchangeObjectAtIndex(NSMutableArray *array, int object1Index, int object2Index);

@end
#pragma clang diagnostic pop