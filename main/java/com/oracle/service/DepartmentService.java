package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Admins;
import com.oracle.pojo.Department;
import com.oracle.pojo.Doctors;

import java.lang.reflect.Member;
import java.util.List;

public interface DepartmentService {
    List<Department> findRootDepartmentList();

    void addDepartment(Department department);

    Integer detectTwoDepartment(Integer departmentPid);

    boolean deleteDepartment(Integer id);

    PageInfo<Department> list(Integer pageNum, Integer pagesize);

    boolean doctorslogin(Doctors doctors);

    boolean adminslogin(Admins admins);

    List<Department> findDepartmentByPid(Integer pid);
}
