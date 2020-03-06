package ru.vsamarin.easy_ee_application.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ExampleRepositoryBase<T> extends RepositoryBase<T> {

    @PersistenceContext(name = "example-persistence-unit")
    private EntityManager em;

    @Override
    protected EntityManager em() {
        return em;
    }
}
