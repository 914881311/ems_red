package com.baizhi.Action;

import com.alibaba.fastjson.JSON;
import com.baizhi.Service.PopleService;
import com.baizhi.entity.Department;
import com.baizhi.entity.Pople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller //创建Action类
@RequestMapping("/pople")//相当于namespaces
public class popleAction {
    @Autowired//给Service做注入
    private PopleService popleService;
    //展示全部
    @RequestMapping("showAll") //使用对象做数据
    public String showAllpople(Model model, HttpServletResponse response)throws Exception{
        List<Department> list = popleService.popleShowAll();
        String jsonString = JSON.toJSONString(list);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
        model.addAttribute("list",list);
        return null;
    }

    //添加员工
    @RequestMapping("insterPop") //使用对象做数据
    public String insterPop(Pople pople, Model model, HttpSession session, MultipartFile upload)throws Exception{
        //获取upload(目标文件夹的路径)
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        //把上传的文件输出到/upload文件夹中  文件名字
        //在upload文件夹中创建了与上传文件同名的文件 空文件
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        //把上传的文件内容转换到空文件中
        upload.transferTo(file);
        pople.setCover(upload.getOriginalFilename());
        popleService.popleIns(pople);
        List<Pople> poples = popleService.popleShowAllList(pople.getDepartment_id());
        model.addAttribute("poples",poples);
        return "ems/emplist";
    }
    //展示所有员工
    @RequestMapping("selectpopleList")//使用对象做数据
    public String selectpopleList(Model model,Integer department_id){
        List<Pople> poples = popleService.popleShowAllList(department_id);
        model.addAttribute("poples",poples);
        return "ems/emplist";
    }
    //删除员工
    @RequestMapping("deletePop")
    public String deletePop(Integer id,Integer department_id,Model model){
        popleService.deletePople(id);
        List<Pople> poples = popleService.popleShowAllList(department_id);
        model.addAttribute("poples",poples);
        return "ems/emplist";
    }
    //修改
    @RequestMapping("updatePop")
    public String updatePop(Pople pople,HttpSession session,MultipartFile upload){
        //获取upload(目标文件夹的路径)
        ServletContext servletContext = session.getServletContext();

        String realPath = servletContext.getRealPath("/upload");
        //把上传的文件输出到/upload文件夹中  文件名字
        //在upload文件夹中创建了与上传文件同名的文件 空文件
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        //把上传的文件内容转换到空文件中
        try {
            upload.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pople.setCover(upload.getOriginalFilename());
        popleService.updatePople(pople);
        return "redirect:/pople/selectpopleList.do?department_id="+pople.getDepartment_id();
    }
    //查询一个员工
    @RequestMapping("/selectById")
    public String seletcById(Pople pople, HttpSession session)throws  Exception{
        Pople pople1 = popleService.selectById(pople.getId());
        session.setAttribute("pople1",pople1);
        return "ems/updateEmp";
    }
}
