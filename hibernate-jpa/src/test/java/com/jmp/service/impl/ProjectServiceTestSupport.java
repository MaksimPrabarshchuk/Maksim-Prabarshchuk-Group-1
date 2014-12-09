package com.jmp.service.impl;

import com.jmp.model.Project;
import com.jmp.service.ProjectService;
import org.junit.AfterClass;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


public class ProjectServiceTestSupport {

    private Project project;

    private static ProjectService projectService = new DefaultProjectService();

    protected void thanProjectIdIsNotNull() {
        assertThat(project.getId(), notNullValue());
    }

    protected void whenProjectSaved() {
        projectService.save(project);
    }

    protected void givenProject() {
        project = new Project();
    }

    @AfterClass
    public static void tearDown() {
        projectService.dispose();
    }

}
