package io.khasang.ba.service.impl;

import io.khasang.ba.dao.DogDao;
import io.khasang.ba.entity.Dog;
import io.khasang.ba.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogDao dogDao;

    @Override
    public Dog addDog(Dog dog) {
        return dogDao.create(dog);
    }

    @Override
    public Dog getDogById(long id) {
        return dogDao.getById(id);
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogDao.getList();
    }
}
