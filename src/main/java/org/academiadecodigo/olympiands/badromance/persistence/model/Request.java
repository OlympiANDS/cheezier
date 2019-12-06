package org.academiadecodigo.olympiands.badromance.persistence.model;

import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

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

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public boolean isTaken(){
        return isTaken;
    }

    public void take(){
        isTaken = true;
    }

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
