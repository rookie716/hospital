package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.DoctorsMapper;
import com.oracle.pojo.Doctors;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class DoctorServiceImpl implements DoctorService{
    @Override
    public Integer getCurrentMaxNumber() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper mapper=sqlSession.getMapper(DoctorsMapper.class);
        String s = mapper.selectMaxNumber();
        sqlSession.close();
        return Integer.parseInt(s);
    }

    @Override
    public void addDoctor(Doctors doctors) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);

        doctors.setEntry_date(new Date());
        String defaultPwd = "12345678";
        defaultPwd= DigestUtils.md5Hex(defaultPwd);
        doctors.setPassword(defaultPwd);

        mapper.addDoctor(doctors);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public Doctors getDoctorById(Integer id) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        Doctors doctors = mapper.selectDoctorById(id);
        sqlSession.close();
        return doctors;
    }

    @Override
    public void modifyDoctor(Doctors doctors) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        mapper.modifyDoctor(doctors);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageInfo<Doctors> doctorSearch(Integer pageNum, Integer pageSize, String name, Integer pid) {
        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper mapper = sqlSession.getMapper(DoctorsMapper.class);
        List<Doctors> doctorsList=mapper.selectDoctorSearch(name, pid);
        sqlSession.close();
        return new PageInfo<>(doctorsList);
    }
}
