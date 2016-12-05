package com.dashboard.services;

import com.dashboard.dao.InstanceDaoImpl;
import com.dashboard.domain.Instance;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class InstanceManagerServices {
    private static final Logger log = LoggerFactory.getLogger(InstanceManagerServices.class);

    @Autowired
    InstanceDaoImpl instanceDao;

    public int reserve(Map<String, Object> data) {
        int errorCode = 0;

        // Add the code to interact with open stack API to create instance
        String serverId = null;
        try {
            JSONObject response = new JSONObject(OpenStackService.reserve());
            serverId = response.getString("uuid");
        } catch (JSONException e) {
            e.printStackTrace();
            errorCode = 1; // Error
        }

        if (errorCode == 0) {
            data.put("uuid", serverId);
            instanceDao.createInstance(data);
        }

        return errorCode;
    }

    public int resume(Map<String, Object> data) {
        OpenStackService.resume((String) data.get("uuid"));
        return 0;
    }

    public int suspend(Map<String, Object> data) {
        OpenStackService.suspend((String) data.get("uuid"));
        return 0;
    }

    public int release(Map<String, Object> data) {
        int errorCode = 0;

        try {
            JSONObject response = new JSONObject(OpenStackService.release((String) data.get("uuid")));
            response.getString("uuid");
        } catch (JSONException e) {
            e.printStackTrace();
            errorCode = 1; // Error
        }

        if (errorCode == 0) { // Success
            data.put("status", "deleted");
            instanceDao.releaseInstance(data);
        }
        return errorCode;
    }

    public List<Instance> getInstanceList(String userName) {
        return instanceDao.getAllInstances(userName);
    }
}
