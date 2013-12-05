/*
 * Copyright (c) 2013, Inversoft Inc., All Rights Reserved
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
package org.savantbuild.runtime;

import org.savantbuild.domain.Project;

/**
 * Runs the build using the {@link Project} and the commands from the user.
 *
 * @author Brian Pontarelli
 */
public interface BuildRunner {
  /**
   * Executes the given targets on the given project.
   *
   * @param project The project.
   * @param targets The targets to run.
   */
  void run(Project project, Iterable<String> targets);
}
