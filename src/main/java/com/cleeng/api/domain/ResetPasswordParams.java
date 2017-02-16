package com.cleeng.api.domain;

import java.io.Serializable;

public class ResetPasswordParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public String resetPasswordToken;

    public String newPassword;

    public ResetPasswordParams(String publisherToken, String customerEmail, String resetPasswordToken, String newPassword) {

        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.resetPasswordToken = resetPasswordToken;
        this.newPassword = newPassword;
    }

    public ResetPasswordParams(String customerEmail, String resetPasswordToken, String newPassword) {

        this.customerEmail = customerEmail;
        this.resetPasswordToken = resetPasswordToken;
        this.newPassword = newPassword;
    }
}
