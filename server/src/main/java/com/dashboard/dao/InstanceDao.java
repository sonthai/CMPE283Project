package com.dashboard.dao;


import java.util.Map;

public interface InstanceDao {
    public void createInstance(Map<String, Object> map);
    public void releaseInstance();
}
