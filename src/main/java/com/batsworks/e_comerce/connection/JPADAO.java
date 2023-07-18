package com.batsworks.e_comerce.connection;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class JPADAO<T> {

    protected final EntityManager entityManager;

    public T create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.flush();
        entityManager.refresh(t);
        entityManager.getTransaction().commit();
        return t;
    }

    public T update(T entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public void delete(Object id) {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    public T findOne(Object id){
        entityManager.getTransaction().begin();
//        entityManager.find(new T(), id)
        entityManager.getTransaction().commit();
        return (T) id;
    }

}
