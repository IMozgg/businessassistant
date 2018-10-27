package io.khasang.ba.dao.impl;

import io.khasang.ba.dao.CarDao;
import io.khasang.ba.entity.Car;

public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {
    public CarDaoImpl(Class<Car> entityClass) {
        super(entityClass);
    }
}
