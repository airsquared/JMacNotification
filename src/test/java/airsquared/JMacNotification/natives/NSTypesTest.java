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
import org.junit.Test;

import static org.junit.Assert.*;

public class NSTypesTest {

    @Test
    public void string() {
        String string = "Hello! 123";
        assertEquals(string, NSTypes.toCString(NSTypes.toNSString(string)));
    }

    @Test
    public void toNSImage() {
        Pointer pointer = NSTypes.toNSImage(getClass().getClassLoader().getResource("test-image.jpeg").getPath());
        assertNotNull(pointer);
        assertTrue(NSTypes.isEqual(pointer, pointer));
    }

}