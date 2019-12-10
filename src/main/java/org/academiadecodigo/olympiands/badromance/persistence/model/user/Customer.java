package org.academiadecodigo.olympiands.badromance.persistence.model.user;

import org.academiadecodigo.olympiands.badromance.persistence.model.AbstractModel;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name="customer")
public class Customer extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "customer",
            fetch = FetchType.EAGER
    )
    private List<Request> requests = new ArrayList<>();

    /**
     * Gets customer first name
     * @return customer first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets customer first name
     * @param firstName name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets customer last name
     * @return customer last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets customer last name
     * @param lastName name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets customer email
     * @return customer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets customer email
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets customer phone number
     * @return customer phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets customer phone number
     * @param phone phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * List all customer requests
     * @return A list of requests from customer
     */
    public List<Request> getRequests() {
        return requests;
    }


    /**
     * Adds a request to customer
     * @param request request to add
     */
    public void addRequest(Request request){
        requests.add(request);
        request.setCustomer(this);
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", requests=" + requests +
                '}';
    }

    /**
     * Completes a request from customer
     * @param id request id to complete
     */
    public void completeRequest(Integer id) {
        requests.get(id-1).complete();
    }
}
