package com.oracle.servlet.backend;

import com.oracle.pojo.Doctors;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/backend/updateDoctorDetailsServlet")
@MultipartConfig
public class UpdateDoctorDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("image");
        Doctors doctors=new Doctors();
            if (part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
                part.write("D:\\xiaoxueqi\\photos\\" + newFileName);
                doctors.setAvatar(newFileName);
            }else {
                doctors.setAvatar(null);
            }


        Integer id=Integer.parseInt(req.getParameter("doctorId"));
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String introduction = req.getParameter("introduction");
        doctors.setDoctor_id(id);
        doctors.setEmail(email);
        doctors.setPhone(phone);
        doctors.setIntroduction(introduction);
        DoctorService doctorService=new DoctorServiceImpl();
        doctorService.modifyDoctor(doctors);
        resp.sendRedirect(req.getContextPath()+"/backend/doctorListServlet");
    }

}
