package org.academiadecodigo.olympiands.badromance.persistence.model;

import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "request")
public class Request extends AbstractModel {

    private Date scheduledTime;
    private String address;
    private String targetName;
    private String genre;
    private String comments;

    @ManyToOne
    private Customer customer;

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
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

    @Override
    public String toString() {
        return "Request{" +
                "scheduledTime=" + scheduledTime +
                ", address='" + address + '\'' +
                ", targetName='" + targetName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
