package com.dashboard.services;

import com.dashboard.dao.InstanceDaoImpl;
import com.dashboard.domain.Instance;
import com.dashboard.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

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
        data.put("status", "running");
        instanceDao.updateInstanceState(data);
        return 0;
    }

    public int suspend(Map<String, Object> data) {
        OpenStackService.suspend((String) data.get("uuid"));
        data.put("status", "suspended");
        instanceDao.updateInstanceState(data);
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
            instanceDao.updateInstanceState(data);
            //instanceDao.releaseInstance(data);
        }
        return errorCode;
    }

    public Map<String, Object> getInstanceData(String userName) {
        Map<String, Object> map = new LinkedHashMap<>();
        List<Instance> instances =  instanceDao.getAllInstances(userName);
        int totalOfHours = 0;

        for (Instance i: instances) {
                int hourDiff = 0;
                if (i.getStatus().equals("running")) {
                    if (map.containsKey("activeInstances")) {
                        map.put("activeInstances", (Integer) map.get("activeInstances") + 1);

                    } else {
                        map.put("activeInstances", 1);
                    }
                    Date today = new Date();
                    hourDiff  = (int) ((today.getTime() - i.getDateCreated().getTime())/ Constants.MILLI_TO_HOUR);
                    i.setHourUsage(hourDiff);
                } else {
                    hourDiff =  (int)((i.getDateModified().getTime() -  i.getDateCreated().getTime())/Constants.MILLI_TO_HOUR);
                    i.setHourUsage(hourDiff);
                }
                totalOfHours += hourDiff;
        }
        map.put("totalOfHours", totalOfHours);
        map.put("numOfInstances", instances.size());
        map.put("instances", instances);
        return map;
    }
}
