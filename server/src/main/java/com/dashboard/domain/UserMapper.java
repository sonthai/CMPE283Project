package com.dashboard.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by leonardlee on 30/11/2016.
 */
public class UserMapper implements RowMapper {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setAccount(rs.getString("account"));
        user.setPwd(rs.getString("pwd"));
        user.setFirst_name(rs.getString("first_name"));
        user.setLast_name(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
