package com.cheer.dao;

import com.cheer.model.Emp;

import java.util.List;

public interface EmpDao {
    //获取指定数据
    Emp getEmp(Integer empNo);
    //获取所有数据
    List<Emp> getList();
    //添加数据
    void insert(Emp emp);
    //删除数据
    void delete(Integer empNo);
    //修改（更新数据）
    void update(Emp emp);
}
