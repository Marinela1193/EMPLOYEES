package org.example.employees2.models.dto;

public class EmployeeDTO {

    private int deptno;
    private String ename;
    private String dloc;
    private String employeeNumber;
    private int superior;

    public EmployeeDTO(int deptno, String ename, String dloc, String employeeNumber, int superior) {
        this.deptno = deptno;
        this.ename = ename;
        this.dloc = dloc;
        this.employeeNumber = employeeNumber;
        this.superior = superior;
    }

    public EmployeeDTO() {
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }
}
