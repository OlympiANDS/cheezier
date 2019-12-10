package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.AssociationExistsException;
import org.academiadecodigo.olympiands.badromance.exceptions.CustomerNotFoundException;
import org.academiadecodigo.olympiands.badromance.exceptions.RequestNotFoundException;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

import java.util.List;
import java.util.Set;

/**
 * Common interface for customer services, provides methods to manage customers and their requests
 */
public interface CustomerService {

    /**
     * Returns an specific customer using an ID
     * @param id customer ID
     * @return a single customer with said ID
     */
    Customer get(Integer id);

    /**
     * Returns an specific customer using an email
     * @param email customer email
     * @return a single customer with said email
     */
    Customer get(String email);

    /**
     * Persist method for customer
     * @param customer customer to persist
     * @return saved customer
     */
    Customer save(Customer customer);

    /**
     * delete a customer by its ID
     * @param id customer id
     * @throws CustomerNotFoundException if customer doesn't exist
     * @throws AssociationExistsException if customer has unsolved requests
     */
    void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException;

    /**
     * list all customer
     * @return list of customer
     */
    List<Customer> list();

    /**
     * list all request from customer
     * @param id customer id
     * @return list of requests
     * @throws CustomerNotFoundException if customer does not exist
     */
    List<Request> listRequests(Integer id) throws CustomerNotFoundException;

    /**
     * Add a new request for specific customer
     * @param id customer id
     * @param request request to be added for said customer
     * @return request added
     * @throws CustomerNotFoundException if costumer does not exist
     * @throws RequestNotFoundException if request does not exist
     */
    Request addRequest(Integer id, Request request) throws CustomerNotFoundException, RequestNotFoundException;

    /**
     * Remove a request from customer
     * @param id customer id
     * @param request request to be removed
     */
    void removeRequest(Integer id, Request request);

    /**
     * Change request state of isCompleted to complete
     * @param cid customer id
     * @param id request id
     */
    void completeRequest(Integer cid, Integer id);

    /**
     * Get all the requests ids from an specific customer
     * @param customer customer to get requests ids from
     * @return set of ids
     */
    Set<Integer> getRequestIds(Customer customer);
}
