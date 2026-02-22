package com.practice.validateEmployee.repositories;

import com.practice.validateEmployee.entities.Activity;
import com.practice.validateEmployee.entities.ActivityId;
import com.practice.validateEmployee.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, ActivityId> {



}
