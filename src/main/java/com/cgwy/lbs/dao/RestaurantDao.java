package com.cgwy.lbs.dao;

import com.cgwy.lbs.entity.Restaurant;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * User: xudong
 * Date: 15/1/6
 * Time: 下午4:38
 */
@Repository
public class RestaurantDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Restaurant> getRestaurants(Collection<Long> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);

        return namedParameterJdbcTemplate.query("select id , user_id as userId, name, " +
                        "region_id as regionId, address, status, " +
                        "create_time as createTime from restaurant " +
                        "where id in (:ids)",
                params, BeanPropertyRowMapper.newInstance(Restaurant.class));
    }






}
