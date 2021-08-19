package com.technomad.webdownload.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

    private String username;
    private String password;

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,
                password.toCharArray());
    }

    public void setPasswordAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
