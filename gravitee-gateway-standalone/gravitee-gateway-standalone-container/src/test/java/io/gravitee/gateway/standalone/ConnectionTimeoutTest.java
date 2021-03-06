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
package io.gravitee.gateway.standalone;

import io.gravitee.gateway.standalone.junit.annotation.ApiConfiguration;
import io.gravitee.gateway.standalone.junit.annotation.ApiDescriptor;
import io.gravitee.gateway.standalone.servlet.TeamServlet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@ApiDescriptor(
        value = "/io/gravitee/gateway/standalone/connect-timeout.json",
        enhanceHttpPort = false)
@ApiConfiguration(
        servlet = TeamServlet.class,
        contextPath = "/team")
public class ConnectionTimeoutTest extends AbstractGatewayTest {

    @Test
    public void call_unreachable_api() throws Exception {
        Request request = Request.Post("http://localhost:8082/unreachable");
        Response response = request.execute();
        HttpResponse returnResponse = response.returnResponse();

        assertTrue(returnResponse.getStatusLine().getStatusCode() == HttpStatus.SC_GATEWAY_TIMEOUT
                    || returnResponse.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_GATEWAY);
    }
}