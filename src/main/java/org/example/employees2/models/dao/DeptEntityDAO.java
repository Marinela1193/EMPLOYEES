package org.example.employees2.models.dao;

import org.example.employees2.models.entities.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeptEntityDAO extends JpaRepository<DeptEntity, Integer> {
    static Optional<DeptEntity> findById(DeptEntity deptno) {
        return null;
    }

}
