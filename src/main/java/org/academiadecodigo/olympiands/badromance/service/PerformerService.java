package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.exceptions.PerformerNotFounException;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;

import java.util.List;

/**
 * Common interface for performer services, provides methods to manage performers and their requests
 */
public interface PerformerService {

    /**
     * Get a performer from id
     * @param id performer id
     * @return an specific performer from said id
     */
    Performer get(Integer id);

    /**
     * Persist a performer
     * @param performer performer to persist
     * @return saved performer
     */
    Performer save(Performer performer);

    /**
     * Delete a performer from context
     *
     * @param id performer id
     * @throws PerformerNotFounException if performer does not exist
     */
    void delete(Integer id) throws PerformerNotFounException;

    /**
     * List all saved performers
     * @return a list of performers
     */
    List<Performer> list();

    /**
     * List all available requests
     * @return
     */
    List<Request> lisRequests();
}
