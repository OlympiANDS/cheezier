package org.academiadecodigo.olympiands.badromance.persistence.dao.jpa;

import org.academiadecodigo.olympiands.badromance.persistence.dao.RequestDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRequestDao extends GenericJpaDao<Request> implements RequestDao {

    public JpaRequestDao() {
        super(Request.class);
    }
}
