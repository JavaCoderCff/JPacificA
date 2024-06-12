/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trs.pacifica.util.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LinkedDataBufferTest {

    DataBuffer dataBuffer1;
    DataBuffer dataBuffer2;
    LinkedDataBuffer linkedDataBuffer;

    byte[] bytes1;

    byte[] bytes2;

    {
        int len = 10;
        this.bytes1 = new byte[len];
        for (int i = 0; i < 10; i++) {
            bytes1[i] = (byte) i;
        }
        dataBuffer1 = new ByteDataBuffer(bytes1);
        this.bytes2 = new byte[len];
        for (int i = 10; i < 20; i++) {
            bytes2[i - 10] = (byte) i;
        }
        dataBuffer2 = new ByteDataBuffer(bytes2);
        linkedDataBuffer = new LinkedDataBuffer(dataBuffer1, dataBuffer2);
    }

    @Test
    void testCapacity() {
        int result = linkedDataBuffer.capacity();
        Assertions.assertEquals(20, result);
    }

    @Test
    void testGet() {
        for (int i = 0; i < 20; i++) {
            byte b = linkedDataBuffer.get();
            Assertions.assertEquals((byte)i, b);
        }
    }

    @Test
    void testGet2() {
        byte result = linkedDataBuffer.get();
        Assertions.assertEquals((byte) 0, result);

        result = linkedDataBuffer.get();
        Assertions.assertEquals((byte) 1, result);

        linkedDataBuffer.position(9);
        result = linkedDataBuffer.get();
        Assertions.assertEquals((byte) 9, result);

        linkedDataBuffer.position(10);
        result = linkedDataBuffer.get();
        Assertions.assertEquals((byte) 10, result);


        linkedDataBuffer.position(19);
        result = linkedDataBuffer.get();
        Assertions.assertEquals((byte) 19, result);
    }

    @Test
    void testGetBytes() {
        byte[] bytes = new byte[20];
        linkedDataBuffer.get(bytes);
        byte[] bytes3 = new byte[20];
        System.arraycopy(this.bytes1, 0, bytes3, 0, 10);
        System.arraycopy(this.bytes2, 0, bytes3, 10, 10);
        Assertions.assertArrayEquals(bytes, bytes3);
    }

    @Test
    void testGetBytes1() {
        byte[] bytes = new byte[12];
        linkedDataBuffer.get(bytes);
        byte[] bytes3 = new byte[12];
        System.arraycopy(this.bytes1, 0, bytes3, 0, 10);
        System.arraycopy(this.bytes2, 0, bytes3, 10, 2);
        Assertions.assertArrayEquals(bytes, bytes3);
    }

    @Test
    void testReadRemain() {
        byte[] b = new byte[2];
        this.linkedDataBuffer.get(b);
        byte[] bytes = this.linkedDataBuffer.readRemain();

        Assertions.assertEquals(18, bytes.length);

    }


    @Test
    void testPosition() {
        linkedDataBuffer.position(11);
        Assertions.assertEquals(11, linkedDataBuffer.position());
    }

    @Test
    void testLimit() {
        int result = linkedDataBuffer.limit();
        Assertions.assertEquals(20, result);
    }

}
