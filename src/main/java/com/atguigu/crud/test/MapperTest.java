package com.atguigu.crud.test;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Empolyee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmpolyeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试DAO层的工作
 * @author kqin050_uottawa
 * @create 2022-01-10 8:21
 *
 * Spring项目使用Spring的单元测试，自动注入需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件位置
 * 3、直接autowired要使用的组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmpolyeeMapper empolyeeMapper;
    @Autowired
    SqlSession sqlSession;
    //测试DepartmentMapper
    @Test
    public void testCRUD(){
        /**
         * 原生测试方法

        //1、创建SpringIOC容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从容器中获得mapper
        ioc.getBean(DepartmentMapper.class);
         */
        System.out.println(departmentMapper);

//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
      departmentMapper.insertSelective(new Department(null, "test"));
      departmentMapper.insertSelective(new Department(null, "development"));
      //2、生成员工数据
        empolyeeMapper.insertSelective(new Empolyee(null,"jerry","M","jerry@gmail.com",1));
        //3、执行批量操作的sqlSession
        EmpolyeeMapper mapper = sqlSession.getMapper(EmpolyeeMapper.class);
        for(int i = 0;i<1000;i++){
            mapper.deleteByPrimaryKey(i);
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Empolyee(null,uid,"M",uid+"@uottawa.ca",1));
        }
        System.out.println("Batch insert Over");
    }
}
