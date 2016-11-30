package com.dashboard.controller;

/**
 * Created by leonardlee on 30/11/2016.
 * How to use Keystone class
 * KeystoneController instance = KeystoneController.getInstance();
 * String toekn = instance.getToken();
 */
public class KeystoneController {
    private static KeystoneController instance = null;
    private String token;

    protected KeystoneController() {

    }

    public static KeystoneController getInstance() {
        if(instance == null) {
            instance = new KeystoneController();
        }
        else {
            // validate the token
            // if the token is not valid, renew the token
        }
        return instance;
    }

    public String getToken() {
        return token;
    }
}
