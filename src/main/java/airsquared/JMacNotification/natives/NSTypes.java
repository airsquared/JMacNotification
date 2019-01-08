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

import com.sun.jna.Pointer;

/**
 * This class contains static methods for creating and converting between ObjC types
 * that are used for other methods in this library.
 *
 * The methods in this class are directly mapped to native code using JNA.
 *
 * To get an NSDate, you have to first create a NSDateComponents
 * and use {@link #toNSDate(Pointer)}.
 *
 * Any method that modifies a NSArray takes a NSMutableArray
 * as an parameter instead of a regular NSArray
 *
 * @author airsquared
 * @see NSUserNotifications
 */
public class NSTypes {

    /* basic convertion functions **/

    /**
     * Underlying ObjC method call: {@code [NSString stringWithUTF8String:string] }
     */
    public static native Pointer toNSString(String string);

    /**
     * ObjC declaration:
     * {@code return string == nil ? NULL : strdup([string UTF8String]); }
     *
     * @param string A Pointer to an ObjC NSString
     */
    public static native String toCString(Pointer string);

    /**
     * Underlying ObjC method call: {@code [[NSImage alloc] initWithContentsOfFile:toNSString(path)] }
     */
    public static native Pointer toNSImage(String path);


    /* NSDate/NSDateComponents functions */

    /**
     * See Apple's documentation for <a href="https://developer.apple.com/documentation/foundation/nsdatecomponents?language=objc">NSDateComponents</a>
     */
    public static native Pointer newNSDateComponents();

    public static native void setDay(Pointer dateComponents, int day);
    public static native int getDay(Pointer dateComponents);

    public static native void setMonth(Pointer dateComponents, int month);
    public static native int getMonth(Pointer dateComponents);

    public static native void setYear(Pointer dateComponents, int year);
    public static native int getYear(Pointer dateComponents);

    public static native void setHour(Pointer dateComponents, int hour);
    public static native int getHour(Pointer dateComponents);

    public static native void setMinute(Pointer dateComponents, int minute);
    public static native int getMinute(Pointer dateComponents);

    public static native void setSecond(Pointer dateComponents, int second);
    public static native int getSecond(Pointer dateComponents);

    /**
     * Underlying ObjC method call: {@code [[NSCalendar currentCalendar] dateFromComponents:dateComponents] }.
     *
     * @param dateComponents A Pointer to an ObjC NSDateComponents
     * @return A pointer to a new ObjC NSDate created from the {@code dateComponents}
     */
    // uses [NSCalendar currentCalendar]
    public static native Pointer toNSDate(Pointer dateComponents);


    /* NSUserNotificationAction functions */

    /**
     * See Apple's documentation for <a href="https://developer.apple.com/documentation/foundation/nsusernotificationaction?language=objc">NSUserNotificationAction</a>.
     * @return A Pointer to a new ObjC NSUserNotificationAction
     */
    public static native Pointer createNSUserNotificationAction(String identifier, String title);

    public static native String getNSUserNotificationActionIdentifier(Pointer action);

    public static native String getNSUserNotificationActionTitle(Pointer action);


    /* NSArray/NSMutableArray functions */
    /**
     * Underlying Objc method call: {@code [NSMutableArray array] }.
     *
     * See Apple's documentation for <a href="https://developer.apple.com/documentation/foundation/nsarray?language=objc">NSArray</a>
     * and <a href="https://developer.apple.com/documentation/foundation/nsmutablearray?language=objc">NSMutableArray</a>.
     */
    public static native Pointer newNSMutableArray();

    // querying an array


    public static native boolean containsObject(Pointer array, Pointer object);

    public static native int count(Pointer array);

    public static native Pointer objectAtIndex(Pointer array, int index);

    // finding objects in an array

    public static native int indexOfObject(Pointer array, Pointer object);

    // adding/inserting objects

    public static native void addObject(Pointer array, Pointer object);

    public static native void insertObjectAtIndex(Pointer array, Pointer object, int index);

    // removing objects

    public static native void removeAllObjects(Pointer array);

    public static native void removeObject(Pointer array, Pointer object);

    public static native void removeObjectAtIndex(Pointer array, int index);

    public static native void removeObjectIdenticalTo(Pointer array, Pointer object);

    // replacing objects

    public static native void replaceObjectAtIndex(Pointer array, int index, Pointer withObject);

    public static native void exchangeObjectAtIndex(Pointer array, int object1Index, int object2Index);

}
