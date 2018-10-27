package io.khasang.ba.service;

import io.khasang.ba.entity.Car;

import java.util.List;

public interface CarService {
    /**
     * method for add Car
     *
     * @param car - new Car for creation
     * @return return Car
     */
    Car addCar(Car car);

    /**
     * method for getting Car by specific id
     *
     * @param id - Car's id
     * @return Car by id
     */
    Car getCarById(long id);

    /**
     * method for getting all Cars
     *
     * @return Car's list
     */
    List<Car> getAllCars();

    /**
     * method for update Car info
     *
     * @param Car - Car for update
     * @return return Car
     */
    Car updateCar(Car Car);

    /**
     * method for deleting Car by specific id
     *
     * @param Car - Car
     */
    void deleteById(Car Car);
}
