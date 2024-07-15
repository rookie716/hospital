package com.oracle.service;

import com.oracle.mapper.DepartmentMapper;
import com.oracle.mapper.DoctorsMapper;
import com.oracle.pojo.Department;
import com.oracle.pojo.ProfessionalTitle;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProfessionalTitleServiceImpl implements ProfessionalTitleService{
    @Override
    public List<ProfessionalTitle> getAll() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper doctorsMapper=sqlSession.getMapper(DoctorsMapper.class);
        List<ProfessionalTitle> professionalTitleList=doctorsMapper.getAll();
        sqlSession.close();
        return professionalTitleList;
    }
}
