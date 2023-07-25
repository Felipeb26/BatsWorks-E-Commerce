package com.batsworks.e_comerce.connection;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import java.util.List;

import static java.util.Objects.isNull;

@SuppressWarnings("unchecked")
@RequiredArgsConstructor
public class JPADAO<T> {

    protected final EntityManager entityManager;

    protected T create(T t) {
        transactionALreadyOpen(entityManager);
        entityManager.persist(t);
//        entityManager.flush();
        entityManager.refresh(t);
        entityManager.getTransaction().commit();
        return t;
    }

    protected T update(T entity) {
        transactionALreadyOpen(entityManager);
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    protected void delete(Class<T> type, Object id) {
        transactionALreadyOpen(entityManager);
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }

    protected T findOne(Class<T> type, Object id) {
        T entity = entityManager.find(type, id);
        entityManager.refresh(entity);
        return entity;
    }

    protected List<T> findAll(Class<T> type) {
        String className = type.getSimpleName();
        Table table = type.getAnnotation(Table.class);
        String initial = className.substring(0, 1).toLowerCase();
        className = isNull(table.name()) ? className : table.name();
        Query query = entityManager.createQuery(String.format("SELECT %s FROM %s %s", initial, className, initial));
        return query.getResultList();
    }

    private static void transactionALreadyOpen(final EntityManager entityManager) {
        if (entityManager.getTransaction().isActive())
            return;
        entityManager.getTransaction().begin();
    }


}
