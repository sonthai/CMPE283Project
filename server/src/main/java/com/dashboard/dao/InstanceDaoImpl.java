package com.dashboard.dao;

import com.dashboard.database.QueryObject;
import com.dashboard.domain.Instance;
import com.dashboard.domain.InstanceMapper;
import com.dashboard.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstanceDaoImpl implements InstanceDao{
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public void createInstance(Map<String, Object> map) {
        map = Utils.setUpInstanceData(map);
        QueryObject query = new QueryObject();
        query.setOperation("INSERT");
        query.setTable("instance_manager");
        List<String> values = Utils.constructQuery(map.keySet(), null, false);
        query.setValues(values);
        String sql = query.getQuery();

        namedParameterJdbcTemplate.update(sql, map);
    }

    public void releaseInstance(Map<String, Object> map) {
        QueryObject query = new QueryObject();
        query.setOperation("UPDATE");
        query.setTable("instance_manager");

        Set<String> fields = new HashSet<>();
        fields.add("status");
        List<String> values = Utils.constructQuery(fields, "=", false);
        query.setValues(values);

        Set<String> whereClauses = new HashSet<>();
        whereClauses.add("uuid");
        whereClauses.add("userName");
        String where = Utils.constructQuery(whereClauses, "=", true).get(0);
        query.setWhereClause(where);

        String sql = query.getQuery();
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Instance> getAllInstances(String userName) {
        List<Instance> instanceList = new ArrayList<>();
        QueryObject query = new QueryObject();
        query.setOperation("SELECT");
        query.setQueryFields(new String[] {"*"});
        query.setTable("instance_manager");
        if (!userName.equals("")) {
            String whereClause = "userName = :userName";
            query.setWhereClause(whereClause);
            String sql = query.getQuery();
            SqlParameterSource params = new MapSqlParameterSource("userName", userName);
            instanceList = namedParameterJdbcTemplate.query(sql, params, new InstanceMapper());
        } else {
            String sql = query.getQuery();
            instanceList = namedParameterJdbcTemplate.query(sql, new InstanceMapper());
        }
        return instanceList;
    }
}
