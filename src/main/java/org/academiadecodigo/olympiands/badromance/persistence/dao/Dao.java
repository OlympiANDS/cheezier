package org.academiadecodigo.olympiands.badromance.persistence.dao;

import org.academiadecodigo.olympiands.badromance.persistence.model.Model;

import java.util.List;


public interface Dao<T extends Model> {

    List<T> finAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}
