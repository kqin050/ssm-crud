package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Empolyee;
import com.atguigu.crud.service.EmpolyeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理员工CRUD请求
 * @author kqin050_uottawa
 * @create 2022-01-10 19:51
 */
@Controller
public class EpolyeeController {
    @Autowired
    EmpolyeeService empolyeeService;

    /**
     * 查询员工数据（分页查询）
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //这不是一个分页查询
        //引入PageHelper分页插件
        //查询之前调用 PageHelper.startPage()方法，传入页码以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是一个分页查询
      List<Empolyee> emps =  empolyeeService.getAll();
      //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
        //pageInfo封装了详细的分页信息，包括查询出来的数据,以及连续显示的页数5页
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
