package com.dashboard.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstanceMapper implements RowMapper {

    @Override
    public Instance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Instance instance = new Instance();
        instance.setId(rs.getInt("id"));
        instance.setUserName(rs.getString("userName"));
        instance.setImageType(rs.getString("imageType"));
        instance.setStatus(rs.getInt("status"));
        instance.setDateCreated(rs.getDate("dateCreated"));;
        instance.setDateReleased(rs.getDate("dateReleased"));
        return instance;
    }
}
