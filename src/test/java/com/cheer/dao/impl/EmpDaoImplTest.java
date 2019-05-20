package com.cheer.dao.impl;

import com.cheer.dao.EmpDao;
import com.cheer.model.Emp;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpDaoImplTest {

    @Test
    public void getEmp() {
        EmpDao empDao=new EmpDaoImpl();
        System.out.println(empDao.getEmp(7788));
    }

    @Test
    public void getList() {
        EmpDao empDao=new EmpDaoImpl();
        List<Emp> list =empDao.getList();
        for(Emp e:list){
            System.out.println(e);
        }

    }

    @Test
    public void insert() {
        EmpDao empDao=new EmpDaoImpl();
        Emp emp=new Emp(1,"张三",null,null,null,88888.0,77.0,10);
        empDao.insert(emp);
    }

    @Test
    public void delete() {
        EmpDao empDao=new EmpDaoImpl();
        empDao.delete(1);

        //第二种方法
        EmpDao empDao1=new EmpDaoImpl();
        Emp emp=new Emp();
        emp.setEmpNo(1);
        empDao1.delete(emp.getEmpNo());

    }

    @Test
    public void update() {
        /*EmpDao empDao=new EmpDaoImpl();
        Emp emp=new Emp();
        emp.setEmpNo(7369);
        emp.setSal(9999.0);
        empDao.update(emp);*/

        EmpDao empDao=new EmpDaoImpl();
        Emp emp=new Emp(7369,"jpy",null,null,null,20000.0,10000.0,10);
        empDao.update(emp);

        EmpDao empDao1=new EmpDaoImpl();
        Emp emp1=empDao1.getEmp(7788);
        emp1.setCom(900.0);
        empDao.update(emp1);




    }
}