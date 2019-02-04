package com.shop.domain.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EditPassword {

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String oldPassword;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String newPassword;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String repitPassword;

    public EditPassword() {

    }
    public EditPassword(String oldPassword, String newPassword, String repitPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.repitPassword = repitPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepitPassword() {
        return repitPassword;
    }
    public void setRepitPassword(String repitPassword) {
        this.repitPassword = repitPassword;
    }
}

