package com.practice.validateEmployee.controller.admin;



import com.practice.validateEmployee.common.StateEmployee;
import com.practice.validateEmployee.common.TypeEmployee;
import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.services.ServicesUtil;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/a/e")
public class EmployeeController {

    @Autowired
    AdminService<Employee>  servicio;

    @GetMapping
    public String findAll(Model model) throws ServiceException {
        log.info("[findAll]");
        List<Employee> list = servicio.findAll();
        log.debug("[Employees List:{}", list);
        model.addAttribute("list", list);
        model.addAttribute("states", StateEmployee.values());
        model.addAttribute("types", TypeEmployee.values());
        return "/search/t_search_employees";
    }


}
