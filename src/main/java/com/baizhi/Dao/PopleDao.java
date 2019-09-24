package com.baizhi.Dao;

import com.baizhi.entity.Department;
import com.baizhi.entity.Pople;

import java.util.List;

public interface PopleDao {

    //展示全部部门
    public List<Department> popleInsterShowAll();
    //添加员工
    public void popleInster(Pople pople);
    //展示所有人员
    public List<Pople> popleSelectAllList(Integer department_id);
    //删除
    public void deleteById(Integer id);
    //修改
    public void updateByPople(Pople pople);
    //查询一个
    public Pople selectOneId(Integer id);
}
