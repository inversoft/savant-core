/*
 * Copyright (c) 2001-2010, Inversoft, All Rights Reserved
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
package org.savantbuild.domain;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * This class defines a target within the build file.
 *
 * @author Brian Pontarelli
 */
public class Target {
  public List<String> dependencies;

  public String description;

  public Runnable invocation;

  public String name;

  public Target() {
  }

  public Target(String name, String description, Runnable invocation, String... dependencies) {
    this.name = name;
    this.description = description;
    this.invocation = invocation;
    this.dependencies = asList(dependencies);
  }
}
