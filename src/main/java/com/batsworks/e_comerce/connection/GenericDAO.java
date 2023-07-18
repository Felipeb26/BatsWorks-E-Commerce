package com.batsworks.e_comerce.connection;

import java.util.List;

public interface GenericDAO<T> {

    T create(T t);

    T update(T t);

    T findOne(Object id);

    void delete(Object id);

    List<T> listAll();

    long count();

}
