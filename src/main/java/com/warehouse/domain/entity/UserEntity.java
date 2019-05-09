package com.warehouse.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    private String name;
    private String lastName;
    private String role;
    private boolean active;

    public UserEntity(String name, String lastName, String role, boolean active, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.active = active;
        this.username = username;
        this.password = password;
    }
}
