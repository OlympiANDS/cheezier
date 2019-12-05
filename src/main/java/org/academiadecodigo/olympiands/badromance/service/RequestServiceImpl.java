package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.persistence.dao.RequestDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao){
        this.requestDao = requestDao;
    }

    @Override
    public Request get(Integer id) {
        return requestDao.findById(id);
    }
}
