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
package com.trs.pacifica;

import com.trs.pacifica.async.Callback;
import com.trs.pacifica.model.LogEntry;
import com.trs.pacifica.model.LogId;

import java.util.List;

public interface LogManager {


    /**
     * @param logEntries
     * @param callback
     */
    public void appendLogEntries(List<LogEntry> logEntries, Callback callback);

    default public void appendLogEntry(final LogEntry logEntry, final Callback callback) {
        appendLogEntries(List.of(logEntry), callback);
    }

    /**
     * get LogEntry at log index
     * @param logIndex
     * @return
     */
    public LogEntry getLogEntryAt(final long logIndex);


    /**
     * get LogId at commit point
     * @return
     */
    public LogId getCommitPoint();

    /**
     * get first log id
     * @return
     */
    public LogId getFirstLogId();

    /**
     * get last log id
     * @return
     */
    public LogId getLastLogId();




    public void waitNewLog(final long waitLogIndex, final NewLogListener listener);


    public static interface NewLogListener {



    }


}

