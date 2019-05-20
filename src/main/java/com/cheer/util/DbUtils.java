package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils{
    private static final DbUtils INSTANCE = new DbUtils();

    private  DbUtils(){}

    public static DbUtils getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        Properties properties=loadResource();
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");
        Connection conn=null;
        try {
            Class.forName(driverClass);
            conn= DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Properties loadResource(){
        //getClassLoader是class方法,返回ClassLoder
        //getResourceAsStream是classLoader方法，返回InputStream
        InputStream is=DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");


        Properties properties=new Properties();
        try {
            properties.load(is);
            if (is!=null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
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