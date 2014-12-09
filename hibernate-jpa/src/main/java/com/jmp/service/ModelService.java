package com.jmp.service;

import com.jmp.model.Address;
import com.jmp.model.Employee;
import com.jmp.model.Personal;

public interface ModelService<T> {

    void save(Object object);

    T findById(long id);

    void deleteById(long id);

    void update(T model);
}
