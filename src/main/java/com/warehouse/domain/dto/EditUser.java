package com.warehouse.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditUser implements Serializable {

    private static final long serialVersionUID = 6529115096976616069L;
    private int id;
    private String email;
    private String name;
    private String lastName;

    @Length(min = 9, max = 9, message = "*Your phone number must have  9 characters")
    @NotEmpty(message = "*Please provide your phone_number")
    private String phoneNumber;

    private String imageUrl;

}
