package io.khasang.ba.service;

import io.khasang.ba.entity.Dog;

import java.util.List;

public interface DogService {
    /**
     * method for add dog
     *
     * @param dog - new dog for creation
     * @return return dog
     */
    Dog addDog(Dog dog);

    /**
     * method for getting Dog by specific id
     * @param id - dog's id
     * @return dog by id
     * */
    Dog getDogById(long id);

    /**
     * method for getting all dogs
     *
     * @return dog's list
     * */
    List<Dog> getAllDogs();
}
