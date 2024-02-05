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

package com.trs.pacifica.log.dir;

import com.trs.pacifica.log.io.DataInOutput;
import com.trs.pacifica.log.io.Input;
import com.trs.pacifica.log.io.Output;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public class NIOFSDirectory extends FsDirectory {

    public NIOFSDirectory(Path path) throws IOException {
        super(path);
    }

    @Override
    public void sync(Collection<String> names) throws IOException {

    }

    @Override
    public DataInOutput openInOutput(String name) throws IOException {
        return null;
    }


    @Override
    public void close() throws IOException {

    }
}
