package com.practice.validateEmployee.repositories;

import com.practice.validateEmployee.entities.Activity;
import com.practice.validateEmployee.entities.ActivityId;
import com.practice.validateEmployee.entities.EmployeeDepartment;
import com.practice.validateEmployee.entities.EmployeeDepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, EmployeeDepartmentId> {


}
