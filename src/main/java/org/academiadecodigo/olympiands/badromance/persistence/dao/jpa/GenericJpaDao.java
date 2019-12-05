package org.academiadecodigo.olympiands.badromance.persistence.dao.jpa;

import org.academiadecodigo.olympiands.badromance.persistence.dao.Dao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    private Class<T> modelType;

    @PersistenceContext
    private EntityManager em;


    public GenericJpaDao(Class<T> modelType){
        this.modelType = modelType;
    }

    public void setEm(EntityManager em){
        this.em = em;
    }

    @Override
    public List<T> finAll() {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T findById(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}
