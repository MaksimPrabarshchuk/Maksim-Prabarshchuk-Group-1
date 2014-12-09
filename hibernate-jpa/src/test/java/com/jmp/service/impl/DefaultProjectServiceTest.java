package com.jmp.service.impl;

import org.junit.Test;

public class DefaultProjectServiceTest extends ProjectServiceTestSupport {

    @Test
    public void testProjectCreation() {
        givenProject();
        whenProjectSaved();
        thanProjectIdIsNotNull();
    }

}
