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
     * method for get entity by id
     * @param id - entity id
     * @return entity by id
     */
    T getById(long id);

    /**
     * get all data from entities
     * @return entities list
     */
    List<T> getList();

    /**
     * method for update entity
     *
     * @param entity - entity for update
     * @return updated entity
     */
    T update(T entity);

    /**
     * method for deleting entity
     * @param entity - entity
     * */
    void deleteById(T entity);
}
