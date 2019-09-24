package com.baizhi.ServiceImpl;

import com.baizhi.Dao.PopleDao;
import com.baizhi.Service.PopleService;
import com.baizhi.entity.Department;
import com.baizhi.entity.Pople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//针对增删改
public class popleServiceImpl implements PopleService {
    @Autowired
    private PopleDao popleDao;
    //展示所有员工
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//查
    public List<Pople> popleShowAllList(Integer department_id) {
        List<Pople> poples = popleDao.popleSelectAllList(department_id);
        return poples;
    }

    //展示全部
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//查
    public List<Department> popleShowAll() {
        List<Department> list = popleDao.popleInsterShowAll();
        return list;
    }

    //添加员工
    @Override
    public void popleIns(Pople pople) {
        popleDao.popleInster(pople);
    }
    //删除员工
    @Override
    public void deletePople(Integer id) {
        popleDao.deleteById(id);
    }
    //修改
    @Override
    public void updatePople(Pople pople) {
        popleDao.updateByPople(pople);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Pople selectById(Integer id) {
        Pople pople = popleDao.selectOneId(id);
        return pople;
    }
}
