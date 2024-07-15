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
@WebServlet("/backend/deleteDepartmentServlet")
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        Integer id = null;
        if (sid != null && !"".equals(sid)) {
            id = Integer.parseInt(sid);
        }
        System.out.println("id="+id);
        DepartmentService departmentService = new DepartmentServiceImpl();
        boolean isDeleted = departmentService.deleteDepartment(id);
        R r1 = new R();
        if (isDeleted) {
            r1.setCode(200);
            r1.setMsg("科室删除成功");
        } else {
            r1.setCode(500);
            r1.setMsg("删除失败，请重试");
        }
        String json = JSONObject.toJSONString(r1);
        resp.setContentType("application/json");
        resp.getWriter().println(json);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
