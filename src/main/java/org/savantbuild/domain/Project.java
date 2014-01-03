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

import org.savantbuild.dep.domain.Artifact;
import org.savantbuild.dep.domain.ArtifactID;
import org.savantbuild.dep.domain.Dependencies;
import org.savantbuild.dep.domain.License;
import org.savantbuild.dep.domain.Version;
import org.savantbuild.dep.graph.ArtifactGraph;
import org.savantbuild.util.Graph;
import org.savantbuild.dep.workflow.Workflow;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This class defines the project.
 *
 * @author Brian Pontarelli
 */
public class Project {
  public static final Object GRAPH_EDGE = new Object();

  public final Map<String, Target> targets = new HashMap<>();

  public final Path directory;

  public ArtifactGraph artifactGraph;

  public Dependencies dependencies;

  public String group;

  public License license;

  public String name;

  public Graph<Target, Object> targetGraph;

  public Version version;

  public Workflow workflow;

  public Path pluginConfigurationDirectory = Paths.get(System.getProperty("user.home") + "/.savant/plugins");

  public Project(Path directory) {
    this.directory = directory;
  }

  /**
   * Converts this project into an Artifact. This artifact uses the project's name for the item name and it has a type
   * of {@code jar}.
   *
   * @return The project artifact.
   */
  public Artifact toArtifact() {
    return new Artifact(new ArtifactID(group, name, name, "jar"), version, license);
  }
}
