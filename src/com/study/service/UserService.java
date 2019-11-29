package com.study.service;

import com.study.domain.PageBean;
import com.study.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询全部用户
     * @return
     */
    public List<User> findAll();

    /**
     * 管理员登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 分页查询用户
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String,String[]> condition);

    /**
     * 删除选中用户
     * @param ids
     */
    public void delSelectedUser(String[] ids);

}
