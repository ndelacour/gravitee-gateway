/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.core.http;

import io.gravitee.common.http.HttpHeaders;
import io.gravitee.gateway.api.Response;

import java.io.OutputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author David BRASSELY (brasseld at gmail.com)
 */
public class HttpServerResponse implements Response {

    private int status;

    private HttpHeaders headers = new HttpHeaders();

    private OutputStream os;

    public int status() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HttpHeaders headers() {
        return headers;
    }

    @Override
    public OutputStream outputStream() {
        return os;
    }

    public void setOutputStream(OutputStream os) {
        this.os = os;
    }

    /*
    public byte [] content() {
        return os.toByteArray();
    }
    */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HttpServerResponse{");
        sb.append("status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
