package com.practice.validateEmployee.services;



import com.practice.validateEmployee.entities.Employee;
import com.practice.validateEmployee.entities.Proyect;
import com.practice.validateEmployee.repositories.ProyectRepository;
import com.practice.validateEmployee.services.exceptions.EmployeeNotFoundException;
import com.practice.validateEmployee.services.exceptions.ProyectNotFoundException;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProyectService implements AdminService<Proyect,Long> {

    ProyectRepository repository;

    public ProyectService(ProyectRepository repositorio) {
        this.repository = repositorio;
    }

    @Override
    public List<Proyect> findAll() throws ServiceException {
        log.info("[findAll]");
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }
    public Proyect findById(Long id) throws ServiceException {
        log.info("[findById]");
        log.debug("[id:{}]",id);
        try {
            return repository.findById(id).orElseThrow(ProyectNotFoundException::new);
        } catch (ServiceException e) {
            log.error("Bussiness Error", e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

    @Override
    public void save(Proyect proyect) throws ServiceException {
        log.debug("[proyect: {}]",proyect);
        try {
             repository.save(proyect);
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }
    }

}
