package com.jmp.service;

import com.jmp.model.Unit;

public interface UnitService extends ModelService<Unit> {

    void createUnit(String title);
}
