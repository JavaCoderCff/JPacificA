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

package com.trs.pacifica.rpc.client;

import com.google.protobuf.Message;
import com.trs.pacifica.proto.RpcRequest;
import com.trs.pacifica.rpc.ReplicaConnection;
import com.trs.pacifica.rpc.RpcResponseCallback;

public interface PacificaClient extends ReplicaConnection {


    static final int DEFAULT_TIMEOUT_MS = 60 * 1000;

    /**
     *
     * @param request
     * @param callback
     * @return
     */
    default Message appendLogEntries(RpcRequest.AppendEntriesRequest request, RpcResponseCallback<RpcRequest.AppendEntriesResponse> callback ) {
        return appendLogEntries(request, callback, DEFAULT_TIMEOUT_MS);
    }

    Message appendLogEntries(RpcRequest.AppendEntriesRequest request, RpcResponseCallback<RpcRequest.AppendEntriesResponse> callback, int timeoutMs);


    default Message installSnapshot(RpcRequest.InstallSnapshotRequest request, RpcResponseCallback<RpcRequest.InstallSnapshotResponse> callback) {
        return installSnapshot(request, callback, DEFAULT_TIMEOUT_MS);
    }

    Message installSnapshot(RpcRequest.InstallSnapshotRequest request, RpcResponseCallback<RpcRequest.InstallSnapshotResponse> callback, int timeoutMs);

}
