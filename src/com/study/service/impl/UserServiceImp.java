package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImp;
import com.study.domain.PageBean;
import com.study.domain.User;
import com.study.service.UserService;


import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService {
    private UserDao userDao =new UserDaoImp();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage<=0){
            currentPage = 1;
        }
        //创建空的PageBea对象
        PageBean<User> pageBean = new PageBean<User>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        //调用到查询总记录数
        int totalCount = userDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1)*rows;
        List<User> list = userDao.findByPage(start,rows,condition);
        pageBean.setList(list);
        //计算总页数
        int totalPage = (totalCount%rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                userDao.delete(Integer.parseInt(id));
            }
        }
    }
}

