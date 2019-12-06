package org.academiadecodigo.olympiands.badromance.command;

import javax.validation.constraints.*;

public class PerformerDto {

    private Integer id;

    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    private String name;


    @Email
    @NotBlank(message = "Required")
    private String email;


    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PerformerDto{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
