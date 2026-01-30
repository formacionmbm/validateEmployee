package com.practice.validateEmployee.services;



import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.repositories.EmployeeRepository;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService implements AdminService<Employee> {

    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repositorio) {
        this.repository = repositorio;
    }

    @Override
    public List<Employee> findAll() throws ServiceException {
        log.info("[findAll]");
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

}
