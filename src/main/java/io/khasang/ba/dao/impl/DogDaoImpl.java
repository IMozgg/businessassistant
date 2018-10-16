package io.khasang.ba.dao.impl;

import io.khasang.ba.dao.DogDao;
import io.khasang.ba.entity.Dog;

public class DogDaoImpl extends BasicDaoImpl<Dog> implements DogDao {
    public DogDaoImpl(Class<Dog> entityClass) {
        super(entityClass);
    }
}
