package com.dashboard.dao;

import com.dashboard.database.QueryObject;
import com.dashboard.domain.*;
import com.dashboard.utils.Utils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kevin on 2016/12/3.
 */
public class AdminDaoImpl implements AdminDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public List<User> getUserList() {
        QueryObject query = new QueryObject();
        query.setOperation("SELECT");
        query.setQueryFields(new String[] {"*"});
        query.setTable("user");
        String sql = query.getQuery();
        List<User> userList = namedParameterJdbcTemplate.query(sql, new UserMapper());
        return userList;
    }

    @Override
    public List<Instance> getInstanceList() {
        QueryObject query = new QueryObject();
        query.setOperation("SELECT");
        query.setQueryFields(new String[] {"*"});
        query.setTable("instance_manager");
//        if (!userName.equals("")) {
//            String whereClause = "userName = :userName";
//            query.setWhereClause(whereClause);
//        }
        String sql = query.getQuery();
//        SqlParameterSource params = new MapSqlParameterSource("userName", userName);
        List<Instance> instanceList = namedParameterJdbcTemplate.query(sql, new InstanceMapper());
        return instanceList;
    }

    @Override
    public List<Billconfig> getBillConfigList() {
        QueryObject query = new QueryObject();
        query.setOperation("SELECT");
        query.setQueryFields(new String[] {"*"});
        query.setTable("billconfig");
        String sql = query.getQuery();
        List<Billconfig> billconfigList = namedParameterJdbcTemplate.query(sql,new RowMapper<Billconfig>() {
            public Billconfig mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                final Billconfig b = new Billconfig();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setType(rs.getInt("type"));
                b.setCharge(rs.getInt("charge"));
                return b;
            }
        });
        return billconfigList;
    }

    @Override
    public List<Billing> getBillingList() {
        QueryObject query = new QueryObject();
        query.setOperation("SELECT");
        query.setQueryFields(new String[] {"*"});
        query.setTable("billing");
        String sql = query.getQuery();
        List<Billing> billingList = namedParameterJdbcTemplate.query(sql,new RowMapper<Billing>() {
            public Billing mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                final Billing b = new Billing();
                b.setUsername(rs.getString("username"));
                b.setBillurl(rs.getString("billurl"));
                b.setDate(Utils.getDate(rs.getTimestamp("date")));
                return b;
            }
        });
        return billingList;
    }
}
