package com.baizhi.Service;

import com.baizhi.entity.Department;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //登陆
    public User loginUser(String username,String password);
    //展示全部
    public List<Department> showAll();
    //添加部门
    public void DepartInster(Department department);
    //修改
    public void DepartUpdate(Department department);
    //根据id查询一个部门
    public Department DepartselectOne(Integer depart_id);
}
