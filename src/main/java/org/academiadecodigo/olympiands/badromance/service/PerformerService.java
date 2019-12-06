package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.PerformerNotFounException;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;

import java.util.List;

public interface PerformerService {
    Performer get(Integer id);
    Performer save(Performer performer);
    void delete(Integer id) throws PerformerNotFounException;
    List<Performer> list();

}
