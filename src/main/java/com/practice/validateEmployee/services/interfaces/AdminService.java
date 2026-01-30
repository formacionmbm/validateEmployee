package com.practice.validateEmployee.services.interfaces;




import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.services.exceptions.ServiceException;

import java.util.List;

public interface AdminService<T> {
    public List<T> findAll() throws ServiceException;
  }
