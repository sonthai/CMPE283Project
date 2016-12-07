package com.dashboard.dao;

import com.dashboard.domain.Billconfig;
import com.dashboard.domain.Billing;
import com.dashboard.domain.Instance;
import com.dashboard.domain.User;

import java.util.List;

/**
 * Created by Kevin on 2016/12/3.
 */
public interface AdminDao {
    public List<User> getUserList();
    public List<Instance> getInstanceList();
    public List<Billconfig> getBillConfigList();
    public List<Billing> getBillingList();
}
