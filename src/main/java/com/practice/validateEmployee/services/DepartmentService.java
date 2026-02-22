package com.practice.validateEmployee.services;



import com.practice.validateEmployee.dto.EmployeeDTO;
import com.practice.validateEmployee.entities.Department;
import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.repositories.DepartmentRepository;
import com.practice.validateEmployee.repositories.EmployeeDepartmentRepository;
import com.practice.validateEmployee.repositories.EmployeeRepository;
import com.practice.validateEmployee.services.exceptions.DepartmentNotFoundException;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminDepartmentService;
import com.practice.validateEmployee.services.interfaces.AdminService;
import com.practice.validateEmployee.services.mapper.Mappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService implements AdminDepartmentService {

    final DepartmentRepository repository;
    final EmployeeRepository employeeRepository;
    final Mappers mappers;


    @Override
    public List<Department> findAll() throws ServiceException {
        log.info("[findAll]");
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

    public Department findById(Long id) throws ServiceException {
        log.info("[findById]");
        log.debug("[id:{}]",id);
        try {
            return repository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        } catch (ServiceException e) {
            log.error("Bussiness Error", e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

    @Override
    public void save(Department department) throws ServiceException {
        log.debug("[department: {}]",department);
        try {
             repository.save(department);
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }
    }

    public List<EmployeeDTO> findEmployees(Long id)throws ServiceException {
        log.info("[findEmployees]");
        log.debug("[id:{}]",id);
        try {
            List<Employee> empleados=employeeRepository.findEmployeeByDepartamentId(id);
            return  empleados.stream()
                    .map(mappers::toDto)
                    .toList();
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

}
