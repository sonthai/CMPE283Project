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

    /*
     * We are forced to hardcode an image ID, because our setup only supports small images
     * due to limited memory. This is why we are using a Cirros image.
     */
    public static final String IMAGE_UUID = "84a9c0cc-107a-427d-b335-0a156300220b";

    // For Testing
    //public static void main(String[] args) throws IOException {
    //    reserve();
    //}

    public static String reserve() {
        // Get Keystone token
        String token = KeystoneController.getToken();
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
                   "        \"imageRef\" : \""+IMAGE_UUID+"\",\n" +
                   "        \"flavorRef\" : \"1\",\n" +
                   "        \"networks\": [{\n" +
                   "    \t\t\"uuid\":\"8a515fb6-eeb4-424f-be7d-cf987060820c\"\n" +
                   "\t\t}]\n" +
                   "    }\n" +
                   "}";

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.close();

            // Get Response
            String response = getResponse(connection);
            JSONObject responseJson = new JSONObject(response);
            JSONObject server = responseJson.getJSONObject("server");
            String serverId = server.getString("id");

            // Ping server status, return error if server missing.
            URL checkUrl = new URL(NOVA_URL + "/servers/" + serverId);
            connection = (HttpURLConnection) checkUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Auth-Token", token);
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            String response2 = getResponse(connection);
            if (response2 != null) {
                JSONObject responseObject = new JSONObject(response2).getJSONObject("server");
                return new JSONObject().put("uuid", serverId).toString();
            }
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
        return "{\"error\": \"Instance creation failed. Please check your setup and try again\"}";
    }

    public static String release(String serverId) {

    }

    private static String getResponse(HttpURLConnection connection) {
        try {
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
