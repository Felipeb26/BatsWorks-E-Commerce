package com.batsworks.e_comerce.repository;

import com.batsworks.e_comerce.connection.GenericDAO;
import com.batsworks.e_comerce.connection.JPADAO;
import com.batsworks.e_comerce.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class UserRepository extends JPADAO<Users> implements GenericDAO<Users> {

    public UserRepository(EntityManager entityManager){
        super(entityManager);
    }

    public Users create(Users users){
        return super.create(users);
    }
    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Users get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<Users> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
