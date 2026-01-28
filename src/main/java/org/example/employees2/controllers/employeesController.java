package org.example.employees2.controllers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.employees2.models.dao.EmployeeEntityDAO;
import org.example.employees2.models.entities.EmployeeEntity;
import org.example.employees2.service.serviceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
class employeesController {
    @Autowired
    serviceEmployee serviceEmployee;

    /*@Autowired
    private DeptEntityDAO deptEntityDAO;*/

    @GetMapping("/")
    public List<EmployeeEntity> findAllUsers() {

        return serviceEmployee.getEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> findUserById(@PathVariable(value = "id") int id) {
        EmployeeEntity employee = serviceEmployee.getEmployeeById(id);

        if(employee != null) {
            return ResponseEntity.ok().body(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@Validated @RequestBody EmployeeEntity employeeEntity) {
       List<EmployeeEntity> listEmployees = serviceEmployee.getEmployees();
        for(EmployeeEntity e : serviceEmployee.getEmployees()){
            if(e.getId().equals(employeeEntity.getId())){
                return ResponseEntity.badRequest().build();
            }
        }
        serviceEmployee.saveEmployee(employeeEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Validated @RequestBody EmployeeEntity employee,@NotNull @Min(0) @PathVariable(value = "id") int id) {
        List<EmployeeEntity> listEmployees = serviceEmployee.getEmployees();
        for (EmployeeEntity e : serviceEmployee.getEmployees()) {
            if (e.getId().equals(employee.getId())) {
                e.setDeptno(employee.getDeptno());
                e.setId(employee.getId());
                e.setEname(employee.getEname());
                e.setJob(employee.getJob());

                return serviceEmployee.updateEmployee(employee);
                return ResponseEntity.ok().body("Updated");
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable (value = "id") int id) {
            List<EmployeeEntity> listEmployees1 = serviceEmployee.getEmployees();
            for(EmployeeEntity e : serviceEmployee.getEmployees()) {
                if (e.getId().equals(id)) {
                    serviceEmployee.deleteById(id);
                    return ResponseEntity.ok().body("Deleted");
                }
            }
            return ResponseEntity.notFound().build();
        }


     /*@GetMapping("/byDeptno/{deptno}")
    public List<EmployeeEntity> findUserByDeptno(@PathVariable(value = "deptno") int deptno) {
        return employeeEntityDAO.findByDeptnoGreaterThan(deptno);
    }*/

    /*@GetMapping("/dto/{id}")
    public ResponseEntity<EmployeeDeptDTO> findEmployeeDTOById(@PathVariable(value = "id") int id) {
        Optional<EmployeeEntity> Employee = employeeEntityDAO.findById(id);

        if(Employee.isPresent()) {
            Optional<DeptEntity> Department = DeptEntityDAO.findById(Employee.get().getDeptno());

        }
        return null;
    }*/
}

