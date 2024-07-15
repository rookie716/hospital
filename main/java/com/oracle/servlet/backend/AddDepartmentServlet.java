package com.oracle.servlet.backend;

import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPid=req.getParameter("pid");
        String deptName=req.getParameter("departmentName");
        String deptDesc=req.getParameter("departmentDesc");
        Integer pid=null;
        if(sPid!=null&& !"".equals(sPid)){
            pid=Integer.parseInt(sPid);
        }

        Department department=new Department();
        department.setDepartmentName(deptName);
        department.setDepartmentPid(pid);
        department.setDepartmentDescription(deptDesc);
        if(pid==null){
            department.setDepartmentLevel(1);
        }else {
            department.setDepartmentLevel(2);
        }
        DepartmentService departmentService=new DepartmentServiceImpl();
        departmentService.addDepartment(department);
        resp.sendRedirect(req.getContextPath()+"/backend/rootDepartmentServlet");
    }
}
