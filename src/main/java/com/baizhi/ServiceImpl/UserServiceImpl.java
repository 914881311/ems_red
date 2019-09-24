package com.baizhi.ServiceImpl;

import com.baizhi.Dao.UserDao;
import com.baizhi.Service.UserService;
import com.baizhi.entity.Department;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//针对增删改
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //登陆
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//查
    public User loginUser(String username, String password) {
        User user = userDao.SelectOne(username, password);
        return user;
    }
    //展示全部部门
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//查
    public List<Department> showAll() {
        List<Department> list = userDao.queryAll();
        return list;
    }
    //添加部门
    @Override
    public void DepartInster(Department department) {
        userDao.UserInsert(department);
    }
    //修改
    @Override
    public void DepartUpdate(Department department) {
        userDao.UserUpdate(department);
    }
    //根据id查一个部门
    @Override
    public Department DepartselectOne(Integer depart_id) {
        Department department = userDao.selectOne(depart_id);
        return department;
    }

}
