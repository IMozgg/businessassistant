package io.khasang.ba.controller;

import io.khasang.ba.entity.Car;
import io.khasang.ba.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody //  Возврат метода Car в формате JSON
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car getCarById(@PathVariable(value = "id") String id) {
        return carService.getCarById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car deleteCar(@PathVariable(value = "id") String id) {
        Car lastCopyCar = carService.getCarById(Long.parseLong(id));
        carService.deleteById(lastCopyCar);
        return lastCopyCar;
    }
}