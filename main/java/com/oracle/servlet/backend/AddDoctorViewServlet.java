package com.oracle.servlet.backend;

import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addDoctorViewServlet")
public class AddDoctorViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorService doctorService=new DoctorServiceImpl();
        Integer number=doctorService.getCurrentMaxNumber();
        number = number+1;
        req.setAttribute("jobNumber",number);
        req.getRequestDispatcher("/admin/doctor/add.jsp").forward(req,resp);
    }
}
