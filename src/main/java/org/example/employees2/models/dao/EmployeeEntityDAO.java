package org.example.employees2.models.dao;
import org.example.employees2.models.dto.EmployeeDTO;
import org.example.employees2.models.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeEntityDAO extends CrudRepository<EmployeeEntity, Integer> {

    @Override
    default <S extends EmployeeEntity> S save(S entity) {
        return null;
    }

    @Override
    default <S extends EmployeeEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<EmployeeEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default Iterable<EmployeeEntity> findAll() {
        return null;
    }

    @Override
    default Iterable<EmployeeEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Integer integer) {

    }

    @Override
    default void delete(EmployeeEntity entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    default void deleteAll(Iterable<? extends EmployeeEntity> entities) {

    }

    @Override
    default void deleteAll() {

    }

    boolean existsById(Integer id);

}
