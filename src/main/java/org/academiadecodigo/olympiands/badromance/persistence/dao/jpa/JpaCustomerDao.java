package org.academiadecodigo.olympiands.badromance.persistence.dao.jpa;

import org.academiadecodigo.olympiands.badromance.persistence.dao.CustomerDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }

}
