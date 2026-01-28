package org.example.employees2.models.dto;

public class EmployeeDTO {
    private int empno;
    private String employeename;
    private String job;
    private int deptno;
    private String dname;
    private String dloc;


    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmployeeName() {
        return employeename;
    }

    public void setEmployeeName(String employeename) {
        this.employeename = employeename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return dloc;
    }

    public void setLoc(String dloc) {
        this.dloc = dloc;
    }

}
