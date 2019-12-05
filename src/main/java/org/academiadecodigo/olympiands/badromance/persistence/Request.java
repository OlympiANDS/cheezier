package org.academiadecodigo.olympiands.badromance.persistence;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Request extends AbstractModel {

    private Date date;
    private String address;
    private String name;
    private String genre;
    private String text;
}
