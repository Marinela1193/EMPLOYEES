package org.example.employees2.controllers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.employees2.models.dao.DeptEntityDAO;
import org.example.employees2.models.dao.EmployeeEntityDAO;
import org.example.employees2.models.dto.EmployeeDeptDTO;
import org.example.employees2.models.entities.DeptEntity;
import org.example.employees2.models.entities.EmployeeEntity;
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
    private EmployeeEntityDAO employeeEntityDAO;

    /*@Autowired
    private DeptEntityDAO deptEntityDAO;*/

    @GetMapping("/")
    public List<EmployeeEntity> findAllUsers() {
        return (List<EmployeeEntity>)  employeeEntityDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> findUserById(@PathVariable(value = "id") int id) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(id);

        if(employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/byDeptno/{deptno}")
    public List<EmployeeEntity> findUserByDeptno(@PathVariable(value = "deptno") int deptno) {
        return employeeEntityDAO.findByDeptnoGreaterThan(deptno);
    }*/

    @GetMapping("/dto/{id}")
    public ResponseEntity<EmployeeDeptDTO> findEmployeeDTOById(@PathVariable(value = "id") int id) {
        Optional<EmployeeEntity> Employee = employeeEntityDAO.findById(id);

        if(Employee.isPresent()) {
            Optional<DeptEntity> Department = DeptEntityDAO.findById(Employee.get().getDeptno());

        }
        return null;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@Validated @RequestBody EmployeeEntity employee) {
        if(!employeeEntityDAO.existsById(employee.getId())) {
            return ResponseEntity.ok(employeeEntityDAO.save(employee));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Validated @RequestBody EmployeeEntity employee,@NotNull @Min(0) @PathVariable(value = "id") int id) {
        if(employeeEntityDAO.existsById(id)) {
            employeeEntityDAO.save(employee);
            return ResponseEntity.ok().body("Updated");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int id) {
        Optional<EmployeeEntity> employee = employeeEntityDAO.findById(id);
        if(employee.isPresent()) {
            employeeEntityDAO.deleteById(id);
            return ResponseEntity.ok().body("Deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
