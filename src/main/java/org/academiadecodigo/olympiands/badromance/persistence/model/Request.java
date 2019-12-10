package org.academiadecodigo.olympiands.badromance.persistence.model;

import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * The request model entity
 */
@Entity
@Table(name = "request")
public class Request extends AbstractModel {

    private String scheduledTime;
    private String address;
    private String targetName;
    private String genre;
    private String comments;
    private boolean isTaken = false;
    private boolean isCompleted = false;

    @ManyToOne
    private Customer customer;

    /**
     * Gets the date for the request in format (DD/MM/YY - 00:00)
     * @return the date
     */
    public String getScheduledTime() {
        return scheduledTime;
    }

    /**
     * Sets the date in format (DD/MM/YY - 00:00)
     * @param scheduledTime the date to set
     */
    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    /**
     * Gets the address where the request is made in google-maps coordinates
     * @return the address as coordinates
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address where the request is made in google-maps coordinates
     * @param address the address as coordinates
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the name of the person to perform the request to
     * @return name of person
     */
    public String getTargetName() {
        return targetName;
    }

    /**
     * Sets the name of the person to perform the request to
     * @param targetName name to set
     */
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    /**
     * Gets the genre of the request
     * @return genre of the request
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the request
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the additional comments that the customer left
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the additional comments that the customer wants the performer to know
     * @param comments the text to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the customer who requested
     * @return Customer from this request
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Assigns the customer to the request
     * @param customer Customer to assign request
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets request status
     * @return request status
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Completes the request
     */
    public void complete() {
        isCompleted = true;
    }

    /**
     * Gets an informative response to performer who wants the request
     * @return request status for performers
     */
    public boolean isTaken(){
        return isTaken;
    }

    /**
     * Sets the request as taken
     */
    public void take(){
        isTaken = true;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Request{" +
                "scheduledTime=" + scheduledTime +
                ", address='" + address + '\'' +
                ", targetName='" + targetName + '\'' +
                ", genre='" + genre + '\'' +
                ", comments='" + comments + '\'' +
                ", isCompleted=" + isCompleted +
                ", customer=" + customer +
                '}';
    }
}
