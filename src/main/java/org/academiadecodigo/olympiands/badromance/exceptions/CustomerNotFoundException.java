package org.academiadecodigo.olympiands.badromance.exceptions;

import org.academiadecodigo.olympiands.badromance.errors.ErrorMessage;

public class CustomerNotFoundException extends BadRomanceException  {

    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND);
    }
}
