package org.academiadecodigo.olympiands.badromance.exceptions;

import org.academiadecodigo.olympiands.badromance.errors.ErrorMessage;

public class RequestNotFoundException extends BadRomanceException {

    public RequestNotFoundException() {
        super(ErrorMessage.REQUEST_NOT_FOUND);
    }
}
