package com.oracle.mapper;

import com.oracle.pojo.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    List<Department> selectRootDepartment();

    void insertDepartment(Department department);

    int selectPidCount(Integer departmentPid);

    void delete(Integer departmentid);

    List<Department> selectDepartmentAll();

    @Select("select department_id as departmentId ,department_name as departmentName from departments where department_pid=#{pid}")
    List<Department> selectDepartmentByPid(Integer pid);
}
