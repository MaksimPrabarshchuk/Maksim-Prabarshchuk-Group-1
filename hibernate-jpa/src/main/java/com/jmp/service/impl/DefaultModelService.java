package com.jmp.service.impl;

import com.jmp.service.ModelService;
import com.jmp.util.HibernateUtil;
import org.hibernate.Session;

public class DefaultModelService<T> implements ModelService<T> {

    private final Class<T> type;
    protected Session session;

    public DefaultModelService(Class<T> type) {
        this.type = type;
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public DefaultModelService(Class<T> type, Session session) {
        this.type = type;
        this.session = session;
    }

    @Override
    public void save(Object object) {
        session.save(object);
    }

    @Override
    public T findById(long id) {
        T model = null;
        try {
            model =  (T) session.get(type, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void deleteById(long id) {
        session.delete(session.get(type, id));
    }

    @Override
    public void update(T model) {
        session.saveOrUpdate(model);
    }

    @Override
    public void dispose() {
        session.close();
    }
}
