package com.dashboard.services;

import com.dashboard.controller.KeystoneController;
import org.json.JSONException;
import org.json.JSONObject;
import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.api.types.ServiceType;
import org.openstack4j.model.common.resolvers.ServiceVersionResolver;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.identity.v3.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.SortedSet;
import java.util.UUID;

/**
 * Created by harshg on 11/27/16.
 */
public class OpenStackService {

    public static final String PROJECT_ID = "611e8923975e4c35a3e575d34d92f27f";
    public static final String NOVA_URL = "http://10.0.0.11:8774/v2.1/"+PROJECT_ID;


    //public static void main(String[] args) throws IOException {
    //    reserve();
    //}

    public static void authenticate2() {
        //Identifier domainIdentifier = Identifier.byId("d8e9291eee684686b276cb1abc31e683");
        /*Identifier projectIdentifier = Identifier.byId("611e8923975e4c35a3e575d34d92f27f");

        OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://10.0.0.11:5000/v3")
                .credentials("admin","admin_user_secret", domainIdentifier)
                .authenticate();

        OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://10.0.0.11:5000/v3")
                .credentials("admin", "admin_user_secret", Identifier.byName("default"))
                .scopeToProject(projectIdentifier)
                .authenticate();

        os.getToken().getCatalog()*/
        //os.getToken();

        // define custom ServiceVersionResolver
        /*final ServiceVersionResolver resolver = new ServiceVersionResolver() {
            @Override
            public Service resolve(ServiceType type, SortedSet<? extends Service> services) {
                // resolver logic; possibly ext. default logic
                switch (type) {
                    case COMPUTE:
                        return new Service() {
                        }"http://10.0.0.11:8774/v2.1/611e8923975e4c35a3e575d34d92f27f/";
                }
                return endpoint;
            }
        };*/

// apply resolver to client
        //OSClient.withConfig(Config.newConfig().withResolver(resolver))


        //Flavor flavor2 = os.compute().flavors().get("1");
        //System.out.println("**********"+flavor2.toString());


        /*List<? extends Flavor> flavors = os.compute().flavors().list();
        for (Flavor flavor : flavors) {
            System.out.println(flavor.toString());

        }*/

    }

    public static String reserve() {
        // Get Keystone token
        String token = KeystoneController.getToken();
        System.out.print("token*******"+token);

        HttpURLConnection connection = null;
        try {
            // Run reservation request, return error if any
            URL url = new URL(NOVA_URL + "/servers");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-Auth-Token", token);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            String body = "{\n" +
                   "    \"server\" : {\n" +
                   "        \"name\" : \""+ UUID.randomUUID().toString()+"\",\n" +
                   "        \"imageRef\" : \"84a9c0cc-107a-427d-b335-0a156300220b\",\n" +
                   "        \"flavorRef\" : \"1\",\n" +
                   "        \"networks\": [{\n" +
                   "    \t\t\"uuid\":\"8a515fb6-eeb4-424f-be7d-cf987060820c\"\n" +
                   "\t\t}]\n" +
                   "    }\n" +
                   "}";

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            JSONObject responseJson = new JSONObject(response.toString());
            JSONObject server = responseJson.getJSONObject("server");
            String serverId = server.getString("id");


            // Ping server status


            return new JSONObject().put("uuid", serverId).toString();

            // Run query for instance, return error if any
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            return new JSONObject().put("error", "Instance creation failed. Please check your setup and try again").toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}
