package com.dashboard.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstanceMapper implements RowMapper {

    @Override
    public Instance mapRow(ResultSet rs, int rowNum) throws SQLException {
        Instance instance = new Instance();
        instance.setUuid(rs.getInt("uuid"));
        instance.setUserName(rs.getString("userName"));
        instance.setImage(rs.getString("image"));
        instance.setIsActive(rs.getInt("isActive"));
        instance.setDateCreated(rs.getDate("dateCreated"));;
        instance.setDateReleased(rs.getDate("dateReleased"));
        instance.setAppName(rs.getString("appName"));
        instance.setMemory(rs.getInt("memory"));
        instance.setCpu(rs.getInt("cpu"));
        instance.setFlavor(rs.getString("flavor"));
        return instance;
    }
}
