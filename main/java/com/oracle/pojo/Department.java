package com.oracle.pojo;

public class Department {
    private Integer departmentId;
    private String departmentName;
    private Integer departmentPid;
    private Integer departmentLevel;
    private String departmentDescription;

    public Department() {
    }

    public Department(Integer departmentId, String departmentName, Integer departmentPid, Integer departmentLevel, String departmentDescription) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentPid = departmentPid;
        this.departmentLevel = departmentLevel;
        this.departmentDescription = departmentDescription;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDepartmentPid() {
        return departmentPid;
    }

    public void setDepartmentPid(Integer departmentPid) {
        this.departmentPid = departmentPid;
    }

    public Integer getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(Integer departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentPid=" + departmentPid +
                ", departmentLevel=" + departmentLevel +
                ", departmentDescription='" + departmentDescription + '\'' +
                '}';
    }
}
