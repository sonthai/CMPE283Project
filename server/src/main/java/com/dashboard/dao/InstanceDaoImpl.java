package com.dashboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class InstanceDaoImpl implements InstanceDao{
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void createInstance(Map<String, Object> map) {
        // /*:status, :imageType, :dateCreated,
        String sql = "Insert into instance_manager (id, userName, status, dateCreated, imageType) values (:id, :userName, :status, :dateCreated, :imageType)";
        map.put("dateCreated", new Date());
        map.put("status", 1);
        Object o = namedParameterJdbcTemplate.execute(sql, map, new PreparedStatementCallback() {
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    public void releaseInstance() {

    }
}
