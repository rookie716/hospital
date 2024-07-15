package com.oracle.listener;

import com.oracle.pojo.Department;
import com.oracle.pojo.ProfessionalTitle;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;
import com.oracle.service.ProfessionalTitleService;
import com.oracle.service.ProfessionalTitleServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
@WebListener
public class InitiallizerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();

        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> rootDepartmentList= departmentService.findRootDepartmentList();
        servletContext.setAttribute("rootDepartmentList",rootDepartmentList);

        ProfessionalTitleService professionalTitleService=new ProfessionalTitleServiceImpl();
        List<ProfessionalTitle> titleAll=professionalTitleService.getAll();
        servletContext.setAttribute("professionalTitleList",titleAll);
        servletContext.setAttribute("root",servletContext.getContextPath());
        servletContext.setAttribute("js",servletContext.getContextPath()+"/js");
        servletContext.setAttribute("css",servletContext.getContextPath()+"/css");
        servletContext.setAttribute("images",servletContext.getContextPath()+"/images");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
