package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.PerformerNotFounException;
import org.academiadecodigo.olympiands.badromance.persistence.dao.PerformerDao;
import org.academiadecodigo.olympiands.badromance.persistence.dao.RequestDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerformerServiceImpl implements PerformerService {

    private PerformerDao performerDao;
    private RequestDao requestDao;

    @Autowired
    public void setPerformerDao(PerformerDao performerDao) {
        this.performerDao = performerDao;
    }

    @Override
    public Performer get(Integer id) {
        return performerDao.findById(id);
    }

    @Transactional
    @Override
    public Performer save(Performer performer) {
        return performerDao.saveOrUpdate(performer);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws PerformerNotFounException {

        Performer performer = performerDao.findById(id);

        if (performer == null){
            throw new PerformerNotFounException();
        }

        performerDao.delete(id);

    }

    @Override
    public List<Performer> list() {
        return performerDao.finAll();
    }

    public List<Request> lisRequests(){
        return requestDao.finAll();
    }
}
