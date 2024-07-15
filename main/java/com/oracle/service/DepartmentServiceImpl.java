package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.AdminsMapper;
import com.oracle.mapper.DepartmentMapper;
import com.oracle.mapper.DoctorsMapper;
import com.oracle.pojo.Admins;
import com.oracle.pojo.Department;
import com.oracle.pojo.Doctors;
import com.oracle.utils.DBUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import sun.security.pkcs11.Secmod;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public List<Department> findRootDepartmentList() {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department>departmentList=departmentMapper.selectRootDepartment();
        sqlSession.close();
        return departmentList;
    }

    @Override
    public void addDepartment(Department department) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        departmentMapper.insertDepartment(department);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Integer detectTwoDepartment(Integer departmentPid) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        Integer idcount=departmentMapper.selectPidCount(departmentPid);
        sqlSession.close();
        return idcount;
    }

    @Override
    public boolean deleteDepartment(Integer id) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        departmentMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @Override
    public PageInfo<Department> list(Integer pageNum, Integer pagesize) {
        PageHelper.startPage(pageNum,pagesize);
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.selectDepartmentAll();
        sqlSession.close();
        return new PageInfo<Department>(departmentList);
    }

    @Override
    public boolean doctorslogin(Doctors doctors) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DoctorsMapper doctorsMapper = sqlSession.getMapper(DoctorsMapper.class);

        Doctors doctors1 = doctorsMapper.selectDoctorsByJobnumber(doctors.getJob_number());
;
        if(doctors1==null){
            return false;
        }

        String pwd= DigestUtils.md5Hex(doctors.getPassword());

        if(!doctors1.getPassword().equals(doctors.getPassword())){
            return false;
        }
        doctors.setDoctor_id(doctors1.getDoctor_id());
        doctors.setPassword(null);
        return true;
    }

    @Override
    public boolean adminslogin(Admins admins) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        AdminsMapper adminsMapper = sqlSession.getMapper(AdminsMapper.class);


        Admins admins1 = adminsMapper.selectAdminsByUsername(admins.getUsername());
        ;
        if(admins1==null){
            return false;
        }

        String pwd= DigestUtils.md5Hex(admins.getPassword());

        if(!admins1.getPassword().equals(admins.getPassword())){
            return false;
        }
        admins.setAdmin_id(admins1.getAdmin_id());
        admins.setPassword(null);
        return true;
    }

    @Override
    public List<Department> findDepartmentByPid(Integer pid) {
        SqlSession sqlSession= DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList = departmentMapper.selectDepartmentByPid(pid);
        sqlSession.close();
        return departmentList;
    }


}
