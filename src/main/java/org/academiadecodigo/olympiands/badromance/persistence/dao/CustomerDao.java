package org.academiadecodigo.olympiands.badromance.persistence.dao;

import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

public interface CustomerDao extends Dao<Customer> {

    Customer findByEmail(String email);
}
