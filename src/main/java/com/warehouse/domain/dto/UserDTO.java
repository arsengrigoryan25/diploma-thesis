package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2331727468970096533L;

    private int id;
    private String name;
    private String lastName;
    private Boolean active;
    private String email;
    private String password;

    public enum Role{
        ADMIN, USER
    }
}
