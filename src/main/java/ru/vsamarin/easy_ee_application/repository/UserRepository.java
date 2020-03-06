package ru.vsamarin.easy_ee_application.repository;

import ru.vsamarin.easy_ee_application.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class UserRepository extends ExampleRepositoryBase<UserEntity> {

    public void create(UserEntity entity) {
        em().persist(entity);
    }

    public UserEntity getById(Long id) {
        return em().find(UserEntity.class, id);
    }

    public List<UserEntity> getList() {
        CriteriaBuilder builder = em().getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
        criteriaQuery.from(UserEntity.class);
        return em().createQuery(criteriaQuery).getResultList();
    }

}
