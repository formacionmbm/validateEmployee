package com.practice.validateEmployee.services.interfaces;

import com.practice.validateEmployee.dto.EmployeeDTO;
import com.practice.validateEmployee.entities.Department;
import com.practice.validateEmployee.services.exceptions.ServiceException;

import java.util.List;

public interface AdminDepartmentService extends AdminService<Department,Long>{
      public List<EmployeeDTO> findEmployees(Long id)throws ServiceException;
}
