package com.batsworks.e_comerce.connection;

import com.batsworks.e_comerce.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public class BatsWorksRepository extends JPADAO<Users> implements GenericDAO<Users> {

    public BatsWorksRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Users create(Users users) {
        return super.create(users);
    }

    public Users save(Users users) {
        return super.create(users);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);
    }

    @Override
    public Users findOne(Object id) {
        return super.findOne(id);
    }

    @Override
    public void delete(Object id) {
        super.delete(id);
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
