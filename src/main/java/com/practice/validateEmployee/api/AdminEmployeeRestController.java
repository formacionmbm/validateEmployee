package com.practice.validateEmployee.api;



import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class AdminEmployeeRestController {

    @Autowired
    AdminService<Employee> servicio;

    @GetMapping("/a")
    public List<Employee> findAll() throws ServiceException {
        log.info("[findAll]");
        List<Employee> list = servicio.findAll();

        log.debug("[Employees list:{}",list);

        return list;
    }


}
