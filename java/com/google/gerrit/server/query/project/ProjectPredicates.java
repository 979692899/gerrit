// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.server.query.project;

import com.google.gerrit.index.FieldDef;
import com.google.gerrit.index.query.IndexPredicate;
import com.google.gerrit.index.query.Predicate;
import com.google.gerrit.reviewdb.client.Project;
import com.google.gerrit.server.index.project.ProjectField;
import com.google.gerrit.server.project.ProjectData;
import java.util.Locale;

public class ProjectPredicates {
  public static Predicate<ProjectData> name(Project.NameKey nameKey) {
    return new ProjectPredicate(ProjectField.NAME, nameKey.get());
  }

  public static Predicate<ProjectData> inname(String name) {
    return new ProjectPredicate(ProjectField.NAME_PART, name.toLowerCase(Locale.US));
  }

  public static Predicate<ProjectData> description(String description) {
    return new ProjectPredicate(ProjectField.DESCRIPTION, description);
  }

  static class ProjectPredicate extends IndexPredicate<ProjectData> {
    ProjectPredicate(FieldDef<ProjectData, ?> def, String value) {
      super(def, value);
    }
  }

  private ProjectPredicates() {}
}
