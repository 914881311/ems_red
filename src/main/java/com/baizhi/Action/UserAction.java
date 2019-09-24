package com.baizhi.Action;

import com.baizhi.Service.UserService;
import com.baizhi.entity.Department;
import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //创建Action
@RequestMapping("/user")//相当于namespaces
public class UserAction extends ActionSupport {
    @Autowired  //给Service做注入
    private UserService userService;
    //登陆
    @RequestMapping("/login") //使用对象数据
    public String UserLogin(User user)throws Exception{
        User user1 = userService.loginUser(user.getUsername(), user.getPassword());
        if(user1!=null){
            return "redirect:/user/showAll.do";
        }else{
            return "redirect:/ems/login.jsp";
        }
    }
    //展示全部
    @RequestMapping("/showAll")
    public String showAll(Model model)throws Exception{
        List<Department> users = userService.showAll();
        model.addAttribute("users",users);
        return "ems/departments";
    }
    //添加部门
    @RequestMapping("/Inster")
    public String Inster(Department department){
        userService.DepartInster(department);
        return "redirect:/user/showAll.do";
    }
    //修改部门
    @RequestMapping("/update")
    public String update(Department department){
        userService.DepartUpdate(department);
        return "redirect:/user/showAll.do";
    }
    //根据id查询一个部门
    @RequestMapping("/select")
    public String select(Integer depart_id,Model model){
        Department department = userService.DepartselectOne(depart_id);
        model.addAttribute("department",department);
        return "ems/updateDepartment";
    }
}
