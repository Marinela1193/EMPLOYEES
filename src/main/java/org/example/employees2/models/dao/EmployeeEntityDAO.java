package org.example.employees2.models.dao;
import org.example.employees2.models.dto.EmployeeDTO;
import org.example.employees2.models.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeEntityDAO extends JpaRepository<EmployeeEntity, Integer> {
    /*List<EmployeeEntity> findByDeptnoGreaterThan(int deptno);
    List<EmployeeEntity> findByDeptnoLessThan(int deptno);

    Object findAll();

    Optional<EmployeeEntity> findById(int id);

    EmployeeEntity save(EmployeeEntity employee);

    void deleteById(int id);*/

    boolean existsById(Integer id);

    boolean existsById(EmployeeDTO employeeDTO);
}
