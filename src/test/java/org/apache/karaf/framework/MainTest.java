/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.framework;

import org.apache.karaf.framework.deployer.OSGiBundleLifecycle;
import org.apache.karaf.framework.test.WithFramework;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@WithFramework
class MainTest {
  @WithFramework.Service
  private StandaloneLifecycle lifecycle;

  @Test
  void testWithDecanter() throws Exception {
    Assertions.assertEquals(5, lifecycle.registry.getBundles().keySet().size());

    OSGiBundleLifecycle bundle =  lifecycle.registry.getBundles().get(1L);
    System.out.println(bundle.getBundle().getBundleId());
    System.out.println(bundle.getBundle().getSymbolicName());

    System.out.println(lifecycle.services.getServices());
  }
}
