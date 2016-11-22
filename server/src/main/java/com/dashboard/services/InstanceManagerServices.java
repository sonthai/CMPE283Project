package com.dashboard.services;

import com.dashboard.dao.InstanceDaoImpl;
import com.dashboard.domain.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class InstanceManagerServices {
    private static final Logger log = LoggerFactory.getLogger(InstanceManagerServices.class);

    @Autowired
    InstanceDaoImpl instanceDao;

    public int reserve(Map<String, Object> data) {
        int result = 0;
        instanceDao.createInstance(data);

        return result;
    }

    public int release(Map<String, String> data) {
        int result = 0;

        return result;
    }

    public List<Instance> getInstanceList(String userName) {
        return instanceDao.getAllInstances(userName);
    }
}
