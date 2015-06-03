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
package io.gravitee.gateway.platforms.jetty;

import io.gravitee.gateway.core.PlatformContext;
import io.gravitee.gateway.platforms.servlet.DispatcherServlet;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public class JettyDispatcherServlet extends DispatcherServlet {

    public final static String GRAVITEE_CONTEXT_ATTRIBUTE = "gravitee.context";

    @Override
    protected PlatformContext getPlatformContext() {
        return (PlatformContext) getServletContext().getAttribute(GRAVITEE_CONTEXT_ATTRIBUTE);
    }
}