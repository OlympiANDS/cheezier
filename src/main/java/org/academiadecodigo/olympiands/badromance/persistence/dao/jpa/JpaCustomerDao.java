package org.academiadecodigo.olympiands.badromance.persistence.dao.jpa;

import org.academiadecodigo.olympiands.badromance.persistence.dao.CustomerDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }

    @Override
    public Customer findByEmail(String email) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

        query.select(root).where(builder.like(root.get("id"), "%email%"));

        Customer customer = em.createQuery(query).getSingleResult();

        return customer;
    }
}
