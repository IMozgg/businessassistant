package io.khasang.ba.service.impl;

import io.khasang.ba.dao.CarDao;
import io.khasang.ba.entity.Car;
import io.khasang.ba.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public Car addCar(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car getCarById(long id) {
        return carDao.getById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getList();
    }

    @Override
    public Car updateCar(Car car) {
        return carDao.update(car);
    }

    @Override
    public void deleteById(Car car) {
        carDao.deleteById(car);
    }
}
