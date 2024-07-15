package com.oracle.servlet.backend;

import com.alibaba.fastjson.JSONObject;
import com.oracle.pojo.R;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPid=req.getParameter("pid");
        Integer pid=null;
        if(sPid!=null&& !"".equals(sPid)){
            pid=Integer.parseInt(sPid);
        }
        DepartmentService departmentService=new DepartmentServiceImpl();
        R r=new R();
        if(departmentService.detectTwoDepartment(pid)>0){
            r.setCode(201);
            r.setMsg("有二级科室，不能删除");
        }else {
            r.setCode(200);
            r.setMsg("无二级科室，进行弹窗");
        }
        String json= JSONObject.toJSONString(r);
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().println(json);
        resp.getWriter().flush();
        resp.getWriter().close();

    }
}
