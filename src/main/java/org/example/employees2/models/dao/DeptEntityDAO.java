package org.example.employees2.models.dao;

import org.example.employees2.models.entities.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeptEntityDAO extends CrudRepository<DeptEntity, Integer> {
    static Optional<DeptEntity> findById(DeptEntity deptno) {
        return null;
    }

    @Override
    <S extends DeptEntity> S save(S entity);

    @Override
    <S extends DeptEntity> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<DeptEntity> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<DeptEntity> findAll();

    @Override
    Iterable<DeptEntity> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(DeptEntity entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends DeptEntity> entities);

    @Override
    void deleteAll();
}
