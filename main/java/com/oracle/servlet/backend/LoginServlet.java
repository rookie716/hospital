package com.oracle.servlet.backend;

import com.oracle.pojo.Admins;
import com.oracle.pojo.Doctors;
import com.oracle.pojo.R;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backend/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName=req.getParameter("username");
        String pwd=req.getParameter("password");
        String roleId=req.getParameter("roleId");
        String requestCode=req.getParameter("code");

        Doctors doctors=new Doctors();
        doctors.setJob_number(loginName);
        doctors.setPassword(pwd);

        Admins admins=new Admins();
        admins.setUsername(loginName);
        admins.setPassword(pwd);

        DepartmentService departmentService=new DepartmentServiceImpl();

        HttpSession session=req.getSession();
        String sessionCode=(String)session.getAttribute("valcode");

        if(requestCode==null||"".equals(requestCode)||!requestCode.equals(sessionCode)){ //验证码有误
            req.setAttribute("captError","验证码有误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }else if(roleId.equals("1")){  //选择医生登录
            if(departmentService.doctorslogin(doctors)){
                R r=new R();
                r.setCode(1);
                r.setData(doctors);
                session.setAttribute("managerInfo",r);
                resp.sendRedirect(req.getContextPath()+"/main.jsp");
                return;
            }else {
                req.setAttribute("loginError","用户名不存在或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                return;
            }
        }else if(roleId.equals("0")){  //选择管理员登录
            if(departmentService.adminslogin(admins)){
                R r=new R();
                r.setCode(0);
                r.setData(admins);
                session.setAttribute("managerInfo",r);
                resp.sendRedirect(req.getContextPath()+"/main.jsp");
            }else {
                req.setAttribute("loginError","用户名不存在或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                return;
            }
        }
    }
}
