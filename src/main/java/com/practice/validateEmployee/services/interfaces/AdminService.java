package com.practice.validateEmployee.services.interfaces;




import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.services.exceptions.ServiceException;

import java.util.List;

public interface AdminService<T,K> {
    public List<T> findAll() throws ServiceException;
    public T findById(K id) throws ServiceException;
    public void save(T element) throws ServiceException;
  }
