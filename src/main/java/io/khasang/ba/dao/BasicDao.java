package io.khasang.ba.dao;

import java.util.List;

public interface BasicDao<T> {

    /**
     *  method for add entity
     *
     * @param entity - new entity for creation
     * @return created entity
     **/
    T create(T entity);

    /**
     * method for get dog by id
     * @param id - dog id
     * @return dog by id
     */
    T getById(long id);

    /**
     * get all data from entities
     * @return entities list
     */
    List<T> getList();
}
