package com.study.dao.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import com.study.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template =new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
