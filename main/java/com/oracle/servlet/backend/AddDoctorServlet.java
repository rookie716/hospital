package com.oracle.servlet.backend;

import com.oracle.pojo.Doctors;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String jobNumber=req.getParameter("jobNumber");
        Integer dID=Integer.parseInt(req.getParameter("departmentId"));
        Integer pID=Integer.parseInt(req.getParameter("professionalTitle"));

        Doctors doctors=new Doctors();
        doctors.setDepartment_id(dID);
        doctors.setName(name);
        doctors.setProfessional_title_id(pID);
        doctors.setJob_number(jobNumber);
        System.out.println(doctors);
        DoctorService service=new DoctorServiceImpl();
        service.addDoctor(doctors);
    }
}
