package com.dashboard.controller;

import com.dashboard.services.OpenStackService;
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

    public static final String ENDPOINT = "http://" + OpenStackService.OPENSTACK_IP + ":5000/v3";

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

        Identifier projectIdentifier = Identifier.byId("611e8923975e4c35a3e575d34d92f27f");
        OSClientV3 os = OSFactory.builderV3()
                .endpoint(ENDPOINT)
                .credentials("admin", "admin_user_secret", Identifier.byName("default"))
                .scopeToProject(projectIdentifier)
                .authenticate();
        return os.getToken().getId();
    }
}
