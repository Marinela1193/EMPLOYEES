package org.example.employees2.service;

import org.example.employees2.models.dao.EmployeeEntityDAO;
import org.example.employees2.models.dto.EmployeeDTO;
import org.example.employees2.models.entities.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceEmployee {
    @Autowired
    private EmployeeEntityDAO employeeEntityDAO;

    /*@Autowired
    private DeptEntityDAO deptEntityDAO;*/

    public List<EmployeeEntity> getEmployees() {
        return (List<EmployeeEntity>) employeeEntityDAO.findAll();
    }

    public EmployeeEntity getEmployeeById(int id) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(id);

        return employee.isPresent() ? employee.get() : null;
    }


    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        if(!employeeEntityDAO.existsById(employeeEntity.getId())){
            return employeeEntityDAO.save(employeeEntity);
        }
        return null;
    }

    public void deleteById(int id) {
        if(employeeEntityDAO.existsById(id)){
            employeeEntityDAO.deleteById(id);
        }
    }

    public void updateEmployee(EmployeeEntity employeeEntity) {
        if(employeeEntityDAO.existsById(employeeEntity.getId())){
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setDeptno(employeeEntity.getDeptno().getId());
            employeeDTO.setEmployeeName(employeeEntity.getEname());
            employeeDTO.setDname(employeeEntity.getDname());
            employeeDTO.setJob((employeeEntity.getJob()));

            return employeeDTO;
        }
    }

    /*public void getEmployeeByDeptNo(String deptNo)  {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById()

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
    }*/
}
