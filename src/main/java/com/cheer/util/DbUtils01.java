package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils01 {
    private static final DbUtils01 INSTANCE =new DbUtils01();

    private DbUtils01(){}

    public static DbUtils01 getInstance(){
        return INSTANCE;
    }

    public Properties loadResource(){
        InputStream is =DbUtils01.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        try {
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Connection getConnection(){
        Properties properties=loadResource();
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn, Statement sta, ResultSet resultSet){
        if (resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (sta!=null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
