package com.oracle.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Doctors {
    private Integer doctor_id;
    private String job_number;
    private String password;
    private String name;
    private String avatar;
    private String phone;
    private String email;
    private String introduction;
    private BigDecimal registration_fee;
    private Date entry_date;
    private Integer department_id;
    private Integer professional_title_id;
    private String departmentName;
    private String professionalTitleName;


    public Doctors() {
    }

    public String getProfessionalTitleName() {
        return professionalTitleName;
    }

    public void setProfessionalTitleName(String professionalTitleName) {
        this.professionalTitleName = professionalTitleName;
    }

    public Doctors(Integer doctor_id, String job_number, String password, String name, String avatar, String phone, String email, String introduction, BigDecimal registration_fee, Date entry_date, Integer department_id, Integer professional_title_id, String professionalTitleName) {
        this.doctor_id = doctor_id;
        this.job_number = job_number;
        this.password = password;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.introduction = introduction;
        this.registration_fee = registration_fee;
        this.entry_date = entry_date;
        this.department_id = department_id;
        this.professional_title_id = professional_title_id;
        this.professionalTitleName = professionalTitleName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public BigDecimal getRegistration_fee() {
        return registration_fee;
    }

    public void setRegistration_fee(BigDecimal registration_fee) {
        this.registration_fee = registration_fee;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getProfessional_title_id() {
        return professional_title_id;
    }

    public void setProfessional_title_id(Integer professional_title_id) {
        this.professional_title_id = professional_title_id;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctor_id=" + doctor_id +
                ", job_number='" + job_number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                ", registration_fee=" + registration_fee +
                ", entry_date=" + entry_date +
                ", department_id=" + department_id +
                ", professional_title_id=" + professional_title_id +
                ", departmentName='" + departmentName + '\'' +
                ", professionalTitleName='" + professionalTitleName + '\'' +
                '}';
    }
}
