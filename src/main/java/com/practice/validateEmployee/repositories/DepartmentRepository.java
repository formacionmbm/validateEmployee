package com.practice.validateEmployee.repositories;

import com.practice.validateEmployee.entities.Department;
import com.practice.validateEmployee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByName(String name);
    @Query("""
            select ed.department
            from EmployeeDepartment ed
            where ed.id.idUser = :idUser
        """)
    public List<Department> findDepartmentsByIdUser(Long idUser);

}
