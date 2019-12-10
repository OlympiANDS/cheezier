package org.academiadecodigo.olympiands.badromance.service;

import org.academiadecodigo.olympiands.badromance.persistence.model.Request;

/**
 * Common interface for requests services, provides methods to manage requests
 */
public interface RequestService {

    /**
     * Get a request by its id
     * @param id request id
     * @return specific request from said id
     */
    Request get(Integer id);
}
