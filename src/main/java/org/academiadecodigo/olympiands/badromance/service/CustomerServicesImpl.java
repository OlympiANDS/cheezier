package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.AssociationExistsException;
import org.academiadecodigo.olympiands.badromance.exceptions.CustomerNotFoundException;
import org.academiadecodigo.olympiands.badromance.exceptions.RequestNotFoundException;
import org.academiadecodigo.olympiands.badromance.persistence.dao.CustomerDao;
import org.academiadecodigo.olympiands.badromance.persistence.dao.RequestDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServicesImpl implements CustomerService {

    private CustomerDao customerDao;
    private RequestDao requestDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDao.saveOrUpdate(customer);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {
        Customer customer = customerDao.findById(id);

        if (customer == null){
            throw new CustomerNotFoundException();
        }

        if (!customer.getRequests().isEmpty()){
            throw new AssociationExistsException();
        }

        customerDao.delete(id);

    }

    @Override
    public List<Customer> list() {
        return customerDao.finAll();
    }

    @Transactional
    @Override
    public List<Request> listRequests(Integer id) throws CustomerNotFoundException {

        Customer customer = customerDao.findById(id);

        if (customer == null){
            throw new CustomerNotFoundException();
        }

        return new ArrayList<>(customerDao.findById(id).getRequests());
    }

    @Transactional
    @Override
    public Request addRequest(Integer id, Request request) throws CustomerNotFoundException {

        Customer customer = customerDao.findById(id);

        if (customer == null){
            throw new CustomerNotFoundException();
        }

        if (requestDao.findById(request.getId()) == null || getRequestIds(customer).contains(request.getId())){
            throw new RequestNotFoundException();
        }

        return null;
    }

    @Override
    public void removeRequest(Integer id, Request request) {

    }

    private Set<Integer> getRequestIds(Customer customer){
        Set<Integer> requestIds = new HashSet<>();
        List<Request> requests = customer.getRequests();

        for (Request request: requests) {
            requestIds.add(request.getId());
        }
        return requestIds;
    }
}
