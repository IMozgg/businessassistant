package io.khasang.ba.controller;

import io.khasang.ba.entity.Dog;
import io.khasang.ba.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dog")
public class DogController {
    @Autowired
    private DogService dogService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody //  Возврат метода Dog в формате JSON
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Dog getDogById(@PathVariable(value = "id") String id) {
        return dogService.getDogById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.updateDog(dog);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Dog deleteDog(@PathVariable(value = "id") String id) {
        Dog lastCopyDog = dogService.getDogById(Long.parseLong(id));
        dogService.deleteById(lastCopyDog);
        return lastCopyDog;
    }
}
