/*
 * Copyright (c) 2014, Inversoft Inc., All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.savantbuild.plugin;

import org.savantbuild.domain.Project;
import org.savantbuild.output.Output;
import org.savantbuild.runtime.RuntimeConfiguration;

/**
 * Sample plugin.
 *
 * @author Brian Pontarelli
 */
public class GoodPlugin implements Plugin {
  public final Output output;

  public final Project project;

  public final RuntimeConfiguration runtimeConfiguration;

  public GoodPlugin(Project project, RuntimeConfiguration runtimeConfiguration, Output output) {
    this.project = project;
    this.output = output;
    this.runtimeConfiguration = runtimeConfiguration;
  }
}
