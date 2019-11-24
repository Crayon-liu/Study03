package com.study.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;
    static{

        try {
            Properties pro = new Properties();
            InputStream is =JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接对象
     */
    public static DataSource getDataSource(){return ds;}

    /**
     * 获取Connection对象
     */
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }

}