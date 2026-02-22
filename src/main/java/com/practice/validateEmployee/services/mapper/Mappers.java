package com.practice.validateEmployee.services.mapper;

import com.practice.validateEmployee.dto.EmployeeDTO;
import com.practice.validateEmployee.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Mappers {

    EmployeeDTO toDto(Employee employee);

    Employee toEntity(EmployeeDTO dto);
}
