package com.dashboard.dao;


import com.dashboard.domain.Instance;

import java.util.List;
import java.util.Map;

public interface InstanceDao {
    public void createInstance(Map<String, Object> map);
    public void releaseInstance(Map<String, Object> map);
    public List<Instance> getAllInstances(String userName);
}
