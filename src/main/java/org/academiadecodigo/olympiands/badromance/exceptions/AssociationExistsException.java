package org.academiadecodigo.olympiands.badromance.exceptions;

import org.academiadecodigo.olympiands.badromance.errors.ErrorMessage;

public class AssociationExistsException extends BadRomanceException {
    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}
