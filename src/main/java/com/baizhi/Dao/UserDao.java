package com.baizhi.Dao;

import com.baizhi.entity.Department;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //登陆
   public User login(User user);
   //根据用户名名和密码查询
    public User SelectOne(@Param("username") String username, @Param("password") String password);

    //展示全部
    public List<Department> queryAll();
    //添加部门
    public void UserInsert(Department department);
    //部门修改
    public void UserUpdate(Department department);
    //根据id查询一个部门
    public Department selectOne(Integer depart_id);


}
