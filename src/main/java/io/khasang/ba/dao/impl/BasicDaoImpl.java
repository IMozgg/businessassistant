package io.khasang.ba.dao.impl;

import io.khasang.ba.dao.BasicDao;
import io.khasang.ba.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    // Работа с сессией
    @Autowired
    protected SessionFactory sessionFactory;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T create(T entity) {
        getSessionFactory().save(entity);
        return entity;
    }

    private Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(long id) {
        return getSessionFactory().get(entityClass, id);
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery =  builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);

        criteriaQuery.select(root);
        return getSessionFactory().createQuery(criteriaQuery).list();

        //return (List<T>) getSessionFactory().createQuery("from T as c").list();
    }

    @Override
    public T update(T entity) {
        getSessionFactory().update(entity);
        return entity;
    }

    @Override
    public void deleteById(T entity) {
        getSessionFactory().delete(entity);
    }
}
