package com.atguigu.crud.service;

import com.atguigu.crud.bean.Empolyee;
import com.atguigu.crud.dao.EmpolyeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kqin050_uottawa
 * @create 2022-01-10 19:58
 */
@Service
public class EmpolyeeService {
    @Autowired
    EmpolyeeMapper empolyeeMapper;
    //查询所有员工
    public List<Empolyee> getAll() {
        return  empolyeeMapper.selectByExampleWithDept(null);
    }
}
