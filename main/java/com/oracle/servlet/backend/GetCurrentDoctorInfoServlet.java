package com.oracle.servlet.backend;

import com.oracle.pojo.Doctors;
import com.oracle.pojo.R;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backend/currentDocterInfoServlet")
public class GetCurrentDoctorInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        R<Doctors> r=(R) session.getAttribute("managerInfo"); //将manageInfo中存储的登录医生的对象传递给新的页面
        Doctors t=r.getData();

        DoctorService doctorService=new DoctorServiceImpl();
        req.setAttribute("doctor",doctorService.getDoctorById(t.getDoctor_id()));
        req.getRequestDispatcher("/admin/doctor/doctorDetails.jsp").forward(req,resp);
    }
}
