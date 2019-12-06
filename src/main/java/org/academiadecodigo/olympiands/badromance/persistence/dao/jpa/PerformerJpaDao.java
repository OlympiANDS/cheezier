package org.academiadecodigo.olympiands.badromance.persistence.dao.jpa;

import org.academiadecodigo.olympiands.badromance.persistence.dao.PerformerDao;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;
import org.springframework.stereotype.Repository;

@Repository
public class PerformerJpaDao extends GenericJpaDao<Performer> implements PerformerDao {
    public PerformerJpaDao() {
        super(Performer.class);
    }
}
