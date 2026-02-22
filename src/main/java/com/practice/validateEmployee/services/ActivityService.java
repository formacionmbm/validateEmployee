package com.practice.validateEmployee.services;



import com.practice.validateEmployee.entities.Activity;
import com.practice.validateEmployee.entities.ActivityId;
import com.practice.validateEmployee.entities.Department;
import com.practice.validateEmployee.repositories.ActivityRepository;
import com.practice.validateEmployee.services.exceptions.ActivityNotFoundException;
import com.practice.validateEmployee.services.exceptions.DepartmentNotFoundException;
import com.practice.validateEmployee.services.exceptions.ServiceException;
import com.practice.validateEmployee.services.interfaces.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ActivityService implements AdminService<Activity, ActivityId> {

    ActivityRepository repository;

    public ActivityService(ActivityRepository repositorio) {
        this.repository = repositorio;
    }

    @Override
    public List<Activity> findAll() throws ServiceException {
        log.info("[findAll]");
        try {
            return repository.findAll();
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }
    public Activity findById(ActivityId id) throws ServiceException {
        log.info("[findById]");
        log.debug("[id:{}]",id);
        try {
            return repository.findById(id).orElseThrow(ActivityNotFoundException::new);
        } catch (ServiceException e) {
            log.error("Bussiness Error", e.getMessage());
            throw e;
        }catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }

    }

    @Override
    public void save(Activity activity) throws ServiceException {
        log.debug("[activity: {}]",activity);
        try {
             repository.save(activity);
        } catch (Exception e) {
            log.error("General Error", e);
            throw new ServiceException();
        }
    }

}
