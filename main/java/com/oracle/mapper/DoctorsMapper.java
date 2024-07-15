package com.oracle.mapper;

import com.oracle.pojo.Doctors;
import com.oracle.pojo.ProfessionalTitle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DoctorsMapper {
    Doctors selectDoctorsByJobnumber(String job_number);

    List<ProfessionalTitle> getAll();

    @Select("select max(job_number) from doctors")
    String selectMaxNumber();

    @Insert("insert into doctors(doctor_id,job_number,password,name,entry_date,department_id,professional_title_id)\t"+
            "values (null,#{job_number},#{password},#{name},#{entry_date},#{department_id},#{professional_title_id})")
    void addDoctor(Doctors doctors);

    @Select("select doctor_id ,job_number ,name as name,avatar as avatar ," +
            "\t phone as phone,email as email,introduction as introduction" +
            "\t from doctors where doctor_id=#{id}")
    Doctors selectDoctorById(Integer id);

    void modifyDoctor(Doctors doctors);

    List<Doctors> selectDoctorSearch(@Param("name") String name, @Param("pid") Integer pid);
}
