package com.practice.validateEmployee.repositories;

import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.entities.Proyect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProyectRepository extends JpaRepository<Proyect,Long> {
    Optional<Proyect> findByName(String name);


}
