package com.cheer.dao.impl;

import com.cheer.dao.EmpDao;
import com.cheer.model.Emp;
import com.cheer.util.DbUtils;
import org.omg.PortableInterceptor.INACTIVE;

import javax.xml.transform.Result;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //查询某一条
    @Override
    public Emp getEmp(Integer empNo) {
        Connection conn=DbUtils.getInstance().getConnection();
        String sql="select * from emp where empno=?";
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        Emp emp=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,empNo);
            resultSet=ps.executeQuery();
            if (resultSet.next()){
                //getString（）,getInt（）都是系统ResultSet类中的方法
                String eName = resultSet.getString("ename");
                String job = resultSet.getString("job");
                Integer mgr = resultSet.getInt("mgr");
                String hireDate = resultSet.getString("hireDate");
                Double sal = resultSet.getDouble("sal");
                Double com = resultSet.getDouble("com");
                Integer deptNo = resultSet.getInt("deptNo");


                emp=new Emp(empNo,eName,job,mgr,hireDate,sal,com,deptNo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(conn,ps,resultSet);
        }
        return emp;
    }

    //查询所有
    @Override
    public List<Emp> getList() {
        Connection conn=DbUtils.getInstance().getConnection();
        String sql="select * from emp";
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        Emp emp=null;
        List<Emp> list=new ArrayList<Emp>();
        try {
            ps=conn.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                Integer empNo=resultSet.getInt("empNo");
                String eName = resultSet.getString("ename");
                String job = resultSet.getString("job");
                Integer mgr = resultSet.getInt("mgr");
                String hireDate = resultSet.getString("hireDate");
                Double sal = resultSet.getDouble("sal");
                Double com = resultSet.getDouble("com");
                Integer deptNo = resultSet.getInt("deptNo");

                emp=new Emp(empNo,eName,job,mgr,hireDate,sal,com,deptNo);
                list.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(conn,ps,resultSet);
        }
        return list;
    }

    //添加数据
    @Override
    public void insert(Emp emp) {
        Connection conn= DbUtils.getInstance().getConnection();
        String sql="insert into emp values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,emp.getEmpNo());
            ps.setString(2,emp.geteName());
            ps.setString(3,emp.getJob());
            ps.setObject(4,emp.getMgr());
            ps.setString(5,emp.getHireDate());
            ps.setDouble(6,emp.getSal());
            ps.setDouble(7,emp.getCom());
            ps.setInt(8,emp.getDeptNo());
            int count=ps.executeUpdate();
            if (count==1){
                System.out.println("添加成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(conn,ps,null);
        }

    }

    //删除数据
    @Override
    public void delete(Integer empNo) {
        Connection conn=DbUtils.getInstance().getConnection();
        String sql="delete from emp where empNo=?";
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,empNo);
            int count=ps.executeUpdate();
            if (count==1){
                System.out.println("删除成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(conn,ps,null);
        }
    }

    //修改数据
    @Override
    public void update(Emp emp) {
        Connection conn=DbUtils.getInstance().getConnection();
        String sql="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,com=?,deptno=? where empno=?";
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,emp.geteName());
            ps.setObject(2,emp.getJob());
            ps.setObject(3,emp.getMgr());
            ps.setObject(4,emp.getHireDate());
            ps.setObject(5,emp.getSal());
            ps.setObject(6,emp.getCom());
            ps.setObject(7,emp.getDeptNo());
            ps.setObject(8,emp.getEmpNo());
            int count=ps.executeUpdate();
            if(count!=0){
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(conn,ps,null);
        }

    }
}
