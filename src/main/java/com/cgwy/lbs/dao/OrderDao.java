package com.cgwy.lbs.dao;

import com.cgwy.lbs.entity.Order;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * User: xudong
 * Date: 15/1/6
 * Time: 下午4:38
 */
@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Order> getUncanceledOrderCreateTimeBetween(Date begin, Date end) {
        return jdbcTemplate.query("select id, price, restaurant_id as restaurantId, status, user_id as userId, " +
                        "shipping_fee as shippingFee, create_time as createTime " +
                        "from order_main o where o.create_time >= ? and o.create_time < ? and status != -1",
                new Object[]{begin, end}, BeanPropertyRowMapper.newInstance(Order.class));
    }
}
