package com.jmp.service;

import com.jmp.model.Project;

public interface ProjectService extends ModelService<Project> {

    void createProject(String title);
}
