package com.dashboard.dao;

import com.dashboard.domain.Instance;
import com.dashboard.domain.InstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class InstanceDaoImpl implements InstanceDao{
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void createInstance(Map<String, Object> map) {
        String sql = "Insert into instance_manager (id, userName, status, dateCreated, imageType) values (:id, :userName, :status, :dateCreated, :imageType)";
        map.put("dateCreated", new Date());
        map.put("status", 1);
        namedParameterJdbcTemplate.update(sql, map);
    }

    public void releaseInstance() {

    }

    @Override
    public List<Instance> getAllInstances(String userName) {
        String sql = "Select * from instance_manager where userName= :userName";
        SqlParameterSource params = new MapSqlParameterSource("userName", userName);
        List<Instance> instanceList = namedParameterJdbcTemplate.query(sql, params, new InstanceMapper());
        return instanceList;
    }
}
