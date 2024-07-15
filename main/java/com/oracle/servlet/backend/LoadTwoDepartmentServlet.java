package com.oracle.servlet.backend;

import com.alibaba.fastjson.JSONObject;
import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/backend/loadTwoDepartmentServlet")
public class LoadTwoDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        Integer rootId=Integer.parseInt(req.getParameter("rootId"));

        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> departmentByPid = departmentService.findDepartmentByPid(rootId);

        String jsonData= JSONObject.toJSONString(departmentByPid);
        resp.getWriter().println(jsonData);
        resp.getWriter().flush();
        resp.getWriter().close();




    }
}
