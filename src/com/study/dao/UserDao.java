package com.study.dao;

import com.study.domain.User;
import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public void add(User user);

    public void update(User user);

    public void delete(int id);

    public int findTotalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
