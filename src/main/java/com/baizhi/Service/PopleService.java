package com.baizhi.Service;

import com.baizhi.entity.Department;
import com.baizhi.entity.Pople;

import java.util.List;

public interface PopleService {
    //展示所有人员
    public List<Pople> popleShowAllList(Integer department_id);
    //展示全部部门
    public List<Department> popleShowAll();
    //添加员工
    public void popleIns(Pople pople);
    //删除员工
    public void deletePople(Integer id);
    //修改
    public void updatePople(Pople pople);
    //根据id查询一个员工信息
    public Pople selectById(Integer id);
}
