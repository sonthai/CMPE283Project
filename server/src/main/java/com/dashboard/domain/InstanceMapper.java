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
        instance.setStatus(rs.getString("status"));
        instance.setDateCreated(rs.getDate("dateCreated"));;
        if (rs.getDate("dateModified") != null) {
            instance.setDateModified(rs.getDate("dateModified"));
        }
        instance.setProjectName(rs.getString("projectName"));
        instance.setMemory(rs.getInt("memory"));
        instance.setCpu(rs.getInt("cpu"));
        instance.setFlavor(rs.getString("flavor"));
        return instance;
    }
}
