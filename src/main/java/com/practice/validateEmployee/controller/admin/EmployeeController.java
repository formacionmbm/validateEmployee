package com.practice.validateEmployee.controller.admin;



import com.practice.validateEmployee.common.StateEmployee;
import com.practice.validateEmployee.common.TypeEmployee;
import com.practice.validateEmployee.common.validation.Create;
import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.services.ServicesUtil;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/a/e")
public class EmployeeController {

    @Autowired
    AdminService<Employee,Long>  servicio;

    @GetMapping
    public String findAll(Model model) throws ServiceException {
        log.info("[findAll]");
        List<Employee> list = servicio.findAll();
        log.debug("[Employees List:{}", list);
        model.addAttribute("list", list);
        return "/admin/t_employees";
    }

    @GetMapping("/n")
    public String formNewEmployee(Model model) throws ServiceException {
        log.info("[formNewEmployee]");

        model.addAttribute("employee", new Employee());

        model.addAttribute("states", StateEmployee.values());
        model.addAttribute("types", TypeEmployee.values());
        return "/admin/t_employee_new";
    }


    @PostMapping
    public String newEmployee(@Validated(Create.class) Employee employee, BindingResult result, Model model)throws ServiceException {
        log.info("[newEmployee]");
        log.debug("[employee:{}]",employee);

        if(result.hasErrors()){
            log.debug("[errores:{}]",result.getFieldErrors());
            model.addAttribute("states", StateEmployee.values());
            model.addAttribute("types", TypeEmployee.values());
            return "/admin/t_employee_new";
        }


        servicio.save(employee);
        log.debug("[Empleado creado]");

        return "redirect:/a/e";
    }
}
