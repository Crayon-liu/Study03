package com.study.dao.impl;

import com.study.dao.UserDao;
import com.study.domain.User;
import com.study.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template =new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,null,null)";
        //执行sql语句
        template.update(sql,user.getName(),user.getAge(),user.getGender(),user.getAddress(),user.getEmail());
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getEmail(),user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
       //定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();

        for(String key : keySet){
            //排除分页条件参数
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");
            }
        }
//        System.out.println(sb.toString());
//        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        sb.append("limit ?,?");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
//        System.out.println(sql);
//        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
