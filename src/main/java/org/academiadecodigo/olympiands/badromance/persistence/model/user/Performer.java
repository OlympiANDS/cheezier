package org.academiadecodigo.olympiands.badromance.persistence.model.user;

import org.academiadecodigo.olympiands.badromance.persistence.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The performer model entity
 */
@Entity
@Table(name = "performer")
public class Performer extends AbstractModel {

    private String name;
    private String email;
    private String phone;


    /**
     * Gets performer name
     * @return performer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets performer name
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets performer email
     * @return performer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets performer email
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets performer phone number
     * @return performer phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets performer phone number
     * @param phone phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Performer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
