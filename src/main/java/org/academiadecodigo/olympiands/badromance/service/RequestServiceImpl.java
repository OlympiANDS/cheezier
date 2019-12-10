package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.persistence.dao.RequestDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An {@link RequestService} implementation
 */
@Service
public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;


    /**
     * Sets the request data access object
     * @param requestDao the request DAO to set
     */
    @Autowired
    public void setRequestDao(RequestDao requestDao){
        this.requestDao = requestDao;
    }

    /**
     * @see RequestService#get(Integer)
     */
    @Override
    public Request get(Integer id) {
        return requestDao.findById(id);
    }
}
