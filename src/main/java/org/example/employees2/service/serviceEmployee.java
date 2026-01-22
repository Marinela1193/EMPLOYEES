package org.example.employees2.service;

import org.example.employees2.models.dao.DeptEntityDAO;
import org.example.employees2.models.dao.EmployeeEntityDAO;
import org.example.employees2.models.dto.EmployeeDTO;
import org.example.employees2.models.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class serviceEmployee {
    @Autowired
    private EmployeeEntityDAO employeeEntityDAO;

    @Autowired
    private DeptEntityDAO deptEntityDAO;

    public List<EmployeeEntity> getEmployees() {
        return (List<EmployeeEntity>) employeeEntityDAO.findAll();
    }

    public EmployeeEntity getEmployeeById(int id) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(id);
        return employee.isPresent() ? employee.get() : null;
    }

    public EmployeeDTO getEmployeeDTO(int id) {
        EmployeeEntity emp = getEmployeeById(id);
        if (emp == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpno(emp.getId());
        dto.setEmployeeName(emp.getEname());
        dto.setJob(emp.getJob());
        if (emp.getDeptno() != null) {
            dto.setDeptno(emp.getDeptno().getId());
            dto.setDname(emp.getDeptno().getDname());
            dto.setLoc(emp.getDeptno().getLoc());
        }
        return dto;
    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeEntity;
    }

    public void deleteById(int id) {
    }

    public void findByDeptnoIsGreaterThan(int deptno) {
    }
}
