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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Integer role;
    private boolean active;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;

    public UserEntity(String name, String lastName, Integer role, boolean active, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.active = active;
        this.username = username;
        this.password = password;
    }
}
