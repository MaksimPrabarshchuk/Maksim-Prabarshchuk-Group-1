package com.jmp.service.impl;

import com.jmp.model.Project;
import com.jmp.service.ProjectService;

public class DefaultProjectService extends DefaultModelService<Project>
        implements ProjectService {

    public DefaultProjectService() {
        super(Project.class);
    }

    @Override
    public void createProject(String title) {
        Project project = new Project(title);
        save(project);
    }
}
