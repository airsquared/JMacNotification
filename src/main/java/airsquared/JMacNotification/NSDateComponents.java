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

public class NSDateComponents {

    private int day = -1;
    private int month = -1;
    private int year = -1;

    private int hour = -1;
    private int minute = -1;
    private int second = -1;

    public NSDateComponents(LocalDateTime localDateTime) {
        this.day = localDateTime.getDayOfMonth();
        this.month = localDateTime.getMonthValue();
        this.year = localDateTime.getYear();

        this.hour = localDateTime.getHour();
        this.minute = localDateTime.getMinute();
        this.second = localDateTime.getSecond();
    }

    public NSDateComponents() {}

    public static NSDateComponents fromNative(Pointer nativeDateComponents) {
        NSDateComponents dateComponents = new NSDateComponents();

        dateComponents.day = NSTypes.getDay(nativeDateComponents);
        dateComponents.month = NSTypes.getMonth(nativeDateComponents);
        dateComponents.year = NSTypes.getYear(nativeDateComponents);

        dateComponents.hour = NSTypes.getHour(nativeDateComponents);
        dateComponents.minute = NSTypes.getMinute(nativeDateComponents);
        dateComponents.second = NSTypes.getSecond(nativeDateComponents);

        return dateComponents;
    }

    public Pointer toNative() {
        Pointer nativeDateComponents = NSTypes.newNSDateComponents();

        NSTypes.setDay(nativeDateComponents, day);
        NSTypes.setMonth(nativeDateComponents, month);
        NSTypes.setYear(nativeDateComponents, year);

        NSTypes.setHour(nativeDateComponents, hour);
        NSTypes.setMinute(nativeDateComponents, minute);
        NSTypes.setSecond(nativeDateComponents, second);

        return nativeDateComponents;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }
}
