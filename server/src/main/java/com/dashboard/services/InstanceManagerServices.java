package com.dashboard.services;

import com.dashboard.dao.InstanceDaoImpl;
import com.dashboard.domain.Instance;
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
        int result = 0;

        // Add the code to interact with open stack API to create instance

        if (result == 0) {
            // Test purpose
            int uuid = (int) (Math.random() * 9999 + 1);
            data.put("uuid", uuid);
            instanceDao.createInstance(data);
        }

        return result;
    }

    public int release(Map<String, Object> data) {
        int result = 0;

        // Add the code to interact with open stack API to release instance
        String uuid = (String) data.get("uuid");

        if (result == 0) {
            data.put("isActive", 0);
            instanceDao.releaseInstance(data);
        }
        return result;
    }

    public List<Instance> getInstanceList(String userName) {
        return instanceDao.getAllInstances(userName);
    }
}
