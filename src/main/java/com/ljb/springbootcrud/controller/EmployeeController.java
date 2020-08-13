package com.ljb.springbootcrud.controller;

import com.ljb.springbootcrud.dao.DepartmentDao;
import com.ljb.springbootcrud.dao.EmployeeDao;
import com.ljb.springbootcrud.entities.Department;
import com.ljb.springbootcrud.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    //查询所有员工返回列表页面
    //返回值会自动拼串
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emps/list";
    }
    //进到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }
    //添加操作
    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps"; //重定向到上面那个controller,如果直接返回的话会被模板引擎解析成页面
    }
    //根据id，跳转修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //添加，修改用同一个页面
        return "emps/add";
    }
    //修改操作
    @PutMapping("/emp")
    public String EditPage(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //删除操作
    @PostMapping("/empdelete/{id}")
    public String deletePage(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
