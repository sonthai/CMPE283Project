package com.dashboard.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.util.Date;
import java.util.Map;

public class UserServices {
    private static final Logger log = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int login(Map<String, String> data) {
        int result = 0;

        return result;
    }

    public int register(Map<String, String> data) {
        int result = 0;

        String sql = "Insert into User (first_name, last_name, account, pwd, email) ";
        sql += "values (:first_name, :last_name, :account, :pwd, :email)";
        namedParameterJdbcTemplate.update(sql, data);
        return result;
    }
}
