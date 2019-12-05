package org.academiadecodigo.olympiands.badromance.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RequestDto {

    private Integer id;

    @NotNull(message = "Date and hour required")
    @NotBlank(message = "Date and hour required")
    private String scheduledTime;


    @NotNull(message = "Address required")
    @NotBlank(message = "Address required")
    private String address;

    @NotNull(message = "Target name required")
    @NotBlank(message = "Target name required")
    private String targetName;

    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    private String genre;

    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "RequestDto{" +
                "id=" + id +
                ", scheduledTime=" + scheduledTime +
                ", address='" + address + '\'' +
                ", targetName='" + targetName + '\'' +
                ", genre='" + genre + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
