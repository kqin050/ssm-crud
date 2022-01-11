package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Empolyee;
import com.atguigu.crud.bean.EmpolyeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpolyeeMapper {
    long countByExample(EmpolyeeExample example);

    int deleteByExample(EmpolyeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Empolyee record);

    int insertSelective(Empolyee record);

    List<Empolyee> selectByExample(EmpolyeeExample example);

    Empolyee selectByPrimaryKey(Integer empId);


    List<Empolyee> selectByExampleWithDept(EmpolyeeExample example);

    Empolyee selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Empolyee record, @Param("example") EmpolyeeExample example);

    int updateByExample(@Param("record") Empolyee record, @Param("example") EmpolyeeExample example);

    int updateByPrimaryKeySelective(Empolyee record);

    int updateByPrimaryKey(Empolyee record);
}