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

package airsquared.JMacNotification;

import airsquared.JMacNotification.natives.NSTypes;
import com.sun.jna.Pointer;

import java.time.LocalDateTime;

/**
 * @author airsquared
 */
public class NSDateComponents implements NSObject {

    private Pointer pointer;

    public NSDateComponents() {
        pointer = NSTypes.newNSDateComponents();
    }

    public NSDateComponents(Pointer p) {
        pointer = p;
    }

    public static NSDateComponents fromLocalDateTime(LocalDateTime localDateTime) {
        NSDateComponents dateComponents = new NSDateComponents();

        dateComponents.setDay(localDateTime.getDayOfMonth());
        dateComponents.setMonth(localDateTime.getMonthValue());
        dateComponents.setYear(localDateTime.getYear());

        dateComponents.setHour(localDateTime.getHour());
        dateComponents.setMinute(localDateTime.getMinute());
        dateComponents.setSecond(localDateTime.getSecond());

        return dateComponents;
    }

    public LocalDateTime toLocalDateTime() {
        return LocalDateTime.of(getYear(), getMonth(), getDay(), getHour(), getMinute(), getSecond());
    }

    public Pointer toNSDate() {
        return NSTypes.toNSDate(getPointer());
    }

    public int getDay() {
        return NSTypes.getDay(pointer);
    }

    public void setDay(int day) {
        NSTypes.setDay(pointer, day);
    }

    public int getMonth() {
        return NSTypes.getMonth(pointer);
    }

    public void setMonth(int month) {
        NSTypes.setMonth(pointer, month);
    }

    public int getYear() {
        return NSTypes.getYear(pointer);
    }

    public void setYear(int year) {
        NSTypes.setYear(pointer, year);
    }

    public int getHour() {
        return NSTypes.getHour(pointer);
    }

    public void setHour(int hour) {
        NSTypes.setHour(pointer, hour);
    }

    public int getMinute() {
        return NSTypes.getMinute(pointer);
    }

    public void setMinute(int minute) {
        NSTypes.setMinute(pointer, minute);
    }

    public int getSecond() {
        return NSTypes.getSecond(pointer);
    }

    public void setSecond(int second) {
        NSTypes.setSecond(pointer, second);
    }

    @Override
    public Pointer getPointer() {
        return pointer;
    }

    @Override
    public String nativeType() { return "NSDateComponents"; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pointer) {
            return NSTypes.isEqual(pointer, (Pointer) obj);
        }
        if (obj instanceof NSObject) {
            return NSTypes.isEqual(pointer, ((NSObject) obj).getPointer());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return NSTypes.hash(pointer);
    }
}
