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
package org.savantbuild.parser.groovy;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.savantbuild.domain.Project;
import org.savantbuild.output.Output;
import org.savantbuild.parser.BuildFileParser;
import org.savantbuild.parser.ParseException;
import org.savantbuild.parser.TargetGraphBuilder;

import groovy.lang.GroovyClassLoader;

/**
 * Parses the build file using a Groovy DSL.
 *
 * @author Brian Pontarelli
 */
public class GroovyBuildFileParser implements BuildFileParser {
  private final TargetGraphBuilder targetGraphBuilder;

  private final Output output;

  public GroovyBuildFileParser(Output output, TargetGraphBuilder targetGraphBuilder) {
    this.output = output;
    this.targetGraphBuilder = targetGraphBuilder;
  }

  /**
   * Executes the script using a GroovyClassLoader and the ProjectBuildFileMetaClass.
   *
   * @param buildFile The file.
   * @return The Project.
   */
  @Override
  public Project parse(Path buildFile) {
    try {
      Map<String, Boolean> optimizationOptions = new HashMap<>();
      optimizationOptions.put("indy", true);

      CompilerConfiguration compilerConfig = new CompilerConfiguration();
      compilerConfig.setScriptBaseClass(ProjectBuildFile.class.getName());
      compilerConfig.setOptimizationOptions(optimizationOptions);

      GroovyClassLoader groovyClassLoader = new GroovyClassLoader(ClassLoader.getSystemClassLoader(), compilerConfig);
      Class<?> buildClass = groovyClassLoader.parseClass(buildFile.toFile());
      ProjectBuildFile script = (ProjectBuildFile) buildClass.newInstance();
      Project project = new Project(buildFile.toAbsolutePath().getParent(), output);
      script.project = project;
      script.output = output;
      script.run();

      project.targetGraph = targetGraphBuilder.build(project);

      return project;
    } catch (IOException | InstantiationException | IllegalAccessException e) {
      throw new ParseException("Unable to parse project build file", e);
    }
  }
}