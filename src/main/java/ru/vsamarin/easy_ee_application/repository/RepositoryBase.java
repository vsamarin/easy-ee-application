package ru.vsamarin.easy_ee_application.repository;

import javax.persistence.EntityManager;

public abstract class RepositoryBase<T> {
    protected abstract EntityManager em();
}
