package com.dashboard.services;

import com.dashboard.dao.AdminDaoImpl;
import com.dashboard.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin on 2016/12/3.
 */
public class AdminServices {
    private static final Logger log = LoggerFactory.getLogger(AdminServices.class);

    @Autowired
    AdminDaoImpl adminDao;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> usermanage() {
        List<User> userList=new ArrayList<>();
        userList = adminDao.getUserList();
        return userList;
    }

    public List<Instance> admininstance(Map<String, String> data) {
        List<Instance> instanceList=new ArrayList<>();
        instanceList = adminDao.getInstanceList();
        return instanceList;
    }

    public List<Billing> billing() {
        List<Billing> billingList=new ArrayList<>();
        billingList = adminDao.getBillingList();
        return billingList;
    }

    public List<Processor> getProcessor() {
        List<Processor> pl=new ArrayList<>();
        String sql = "select * from processor";
        pl = namedParameterJdbcTemplate.query(sql, new InstanceMapper());
        return pl;
    }

    public List<Memory> getMemory() {
        List<Memory> ml=new ArrayList<>();
        String sql = "select * from memory";
        ml = namedParameterJdbcTemplate.query(sql, new InstanceMapper());
        return ml;
    }

    public List<Storage> getStorage() {
        List<Storage> sl=new ArrayList<>();
        String sql = "select * from storage";
        sl = namedParameterJdbcTemplate.query(sql, new InstanceMapper());
        return sl;
    }

    public void addbillconfig(Map<String, String> data) {
        String sql = "Insert into Billconfig (name,processor,memory,storage,type,charge) ";
        sql += "values (:name, :processor, :memory, :storage, :type, :charge)";
        namedParameterJdbcTemplate.update(sql, data);
    }

    public List<Billconfig> billConfig() {
        List<Billconfig> billconfigList=new ArrayList<>();
        billconfigList = adminDao.getBillConfigList();
        return billconfigList;
    }
}
