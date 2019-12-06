package org.academiadecodigo.olympiands.badromance.exceptions;

import org.academiadecodigo.olympiands.badromance.errors.ErrorMessage;

public class PerformerNotFounException extends BadRomanceException {
    public PerformerNotFounException() {
        super(ErrorMessage.PERFORMER_NOT_FOUND);
    }
}
