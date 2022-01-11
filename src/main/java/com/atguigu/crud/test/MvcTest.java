package com.atguigu.crud.test;

import com.atguigu.crud.bean.Empolyee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * 使用Spring测试模块测试请求功能，测试crud
 * @author kqin050_uottawa
 * @create 2022-01-10 20:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml",
        "file:D:/workspace_idea/ssm-crud/ssm-crud/src/main/webapp/WEB-INF/dispathcerServlet-servlet.xml"})

public class MvcTest {
    //传入Springmvc的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求，获得处理结果
    MockMvc mockMvc;
    @Before
    public void initMocMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5"))
                .andReturn();
        //请求成功以后，请求域中会有pageInfo，可以去取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pi.getPageNum());
        System.out.println("总页码"+pi.getPages());
        System.out.println("总记录数"+pi.getTotal());

        List<Empolyee> list = pi.getList();
        for (Empolyee empolyee: list){
            System.out.println("ID: "+empolyee.getdId() + "name: " + empolyee.getEmpName());
        }
    }
}
