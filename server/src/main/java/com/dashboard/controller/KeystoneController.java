package com.dashboard.controller;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.identity.v3.User;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.model.common.Identifier;

/**
 * Created by leonardlee on 30/11/2016.
 * How to use Keystone class
 * KeystoneController instance = KeystoneController.getInstance();
 * String toekn = instance.getToken();
 */
public class KeystoneController {
    private static KeystoneController instance = null;

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

    public static String getToken() {

        OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://127.0.0.1:5000/v3")
                .credentials("admin","admin_user_secret", Identifier.byName("default"))
                .authenticate();
        return os.getToken().getId();
    }
}
