package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Doctors;

import java.util.List;

public interface DoctorService {
    Integer getCurrentMaxNumber();

    void addDoctor(Doctors doctors);

    Doctors getDoctorById(Integer id);

    void modifyDoctor(Doctors doctors);

    PageInfo<Doctors> doctorSearch(Integer pageNum, Integer pageSize, String name, Integer pid);
}
