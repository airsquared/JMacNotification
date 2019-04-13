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

import java.util.ArrayList;
import java.util.List;

/**
 * @author airsquared
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class NSArray implements NSObject {

    private Pointer pointer;

    public NSArray() {
        pointer = NSTypes.newNSMutableArray();
    }
    public NSArray(Pointer p) {
        pointer = p;
    }

    public static NSArray fromPointerList(List<Pointer> list) {
        NSArray array = new NSArray();
        list.forEach(array::add);
        return array;
    }

    public static NSArray fromNSObjectList(List<NSObject> list) {
        NSArray array = new NSArray();
        list.forEach(array::add);
        return array;
    }

    public ArrayList<Pointer> toList() {
        ArrayList<Pointer> arrayList = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            arrayList.add(get(i));
        }
        return arrayList;
    }

    public int size() {
        return NSTypes.count(pointer);
    }

    public boolean contains(Pointer nsObject) {
        return NSTypes.containsObject(pointer, nsObject);
    }

    public boolean contains(NSObject object) {
        return contains(object.getPointer());
    }

    public int indexOf(Pointer nsObject) {
        return NSTypes.indexOfObject(pointer, nsObject);
    }

    public int indexOf(NSObject object) {
        return indexOf(object.getPointer());
    }

    public void add(Pointer nsObject) {
        NSTypes.addObject(pointer, nsObject);
    }

    public void add(NSObject object) {
        add(object.getPointer());
    }

    public void add(int index, Pointer nsObject) {
        NSTypes.insertObjectAtIndex(pointer, nsObject, index);
    }

    public void add(int index, NSObject object) {
        add(index, object.getPointer());
    }

    public void set(int index, Pointer nsObject) {
        NSTypes.replaceObjectAtIndex(pointer, index, nsObject);
    }

    public void set(int index, NSObject object) {
        set(index, object.getPointer());
    }

    public Pointer get(int index) {
        return NSTypes.objectAtIndex(pointer, index);
    }

    public void remove(Pointer nsObject) {
        NSTypes.removeObject(pointer, nsObject);
    }

    public void remove(NSObject object) {
        remove(object.getPointer());
    }

    public void remove(int index) {
        NSTypes.removeObjectAtIndex(pointer, index);
    }

    public void clear() {
        NSTypes.removeAllObjects(pointer);
    }

    @Override
    public Pointer getPointer() {
        return pointer;
    }

    @Override
    public String nativeType() {
        return "NSArray";
    }

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
