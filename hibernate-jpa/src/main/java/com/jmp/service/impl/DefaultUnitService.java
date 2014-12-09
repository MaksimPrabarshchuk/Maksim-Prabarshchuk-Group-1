package com.jmp.service.impl;

import com.jmp.model.Unit;
import com.jmp.service.UnitService;

public class DefaultUnitService extends DefaultModelService<Unit>
        implements UnitService {

    public DefaultUnitService() {
        super(Unit.class);
    }

    @Override
    public void createUnit(String title) {
        Unit unit = new Unit(title);
        save(unit);
    }
}
