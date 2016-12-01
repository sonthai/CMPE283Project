package com.dashboard.services;

import com.dashboard.domain.User;
import com.dashboard.domain.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import java.util.Date;
import java.util.Map;

public class UserServices {
    private static final Logger log = LoggerFactory.getLogger(UserServices.class);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean login(Map<String, String> data) {
        int result = 0;
        String sql = "SELECT * FROM User WHERE account = :account";
        SqlParameterSource namedParameter = new MapSqlParameterSource("account", data.get("account"));
        User user = (User)namedParameterJdbcTemplate.queryForObject(sql, namedParameter, new UserMapper());
        if (user.getPwd() == data.get("pwd")) {
            return true;
        }
        else {
            return false;
        }
    }

    public int register(Map<String, String> data) {
        int result = 0;

        String sql = "Insert into User (first_name, last_name, account, pwd, email) ";
        sql += "values (:first_name, :last_name, :account, :pwd, :email)";
        namedParameterJdbcTemplate.update(sql, data);
        return result;
    }
}
