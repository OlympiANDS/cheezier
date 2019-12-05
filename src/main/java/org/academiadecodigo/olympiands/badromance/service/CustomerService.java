package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.AssociationExistsException;
import org.academiadecodigo.olympiands.badromance.exceptions.CustomerNotFoundException;
import org.academiadecodigo.olympiands.badromance.exceptions.RequestNotFoundException;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

import java.util.List;

public interface CustomerService {

    Customer get(Integer id);
    Customer save(Customer customer);
    void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException;
    List<Customer> list();
    List<Request> listRequests(Integer id) throws CustomerNotFoundException;
    Request addRequest(Integer id, Request request) throws CustomerNotFoundException, RequestNotFoundException;
    void removeRequest(Integer id, Request request);


}
