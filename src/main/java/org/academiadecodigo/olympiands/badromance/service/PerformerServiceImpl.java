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

/**
 * An {@link PerformerService} implementation
 */
@Service
public class PerformerServiceImpl implements PerformerService {

    private PerformerDao performerDao;
    private RequestDao requestDao;

    /**
     * Sets the performer data access object
     * @param performerDao the performer DAO to set
     */
    @Autowired
    public void setPerformerDao(PerformerDao performerDao) {
        this.performerDao = performerDao;
    }

    /**
     * @see PerformerService#get(Integer)
     */
    @Override
    public Performer get(Integer id) {
        return performerDao.findById(id);
    }

    /**
     * @see PerformerService#save(Performer)
     */
    @Transactional
    @Override
    public Performer save(Performer performer) {
        return performerDao.saveOrUpdate(performer);
    }

    /**
     * @see PerformerService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws PerformerNotFounException {

        Performer performer = performerDao.findById(id);

        if (performer == null){
            throw new PerformerNotFounException();
        }

        performerDao.delete(id);

    }

    /**
     * @see PerformerService#list()
     */
    @Override
    public List<Performer> list() {
        return performerDao.finAll();
    }

    /**
     * @see PerformerService#lisRequests()
     */
    @Override
    public List<Request> lisRequests(){
        return requestDao.finAll();
    }
}
