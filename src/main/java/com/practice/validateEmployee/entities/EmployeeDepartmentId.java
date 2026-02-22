package com.practice.validateEmployee.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class EmployeeDepartmentId {

    private int idUser;
    private int idDepartment;
}
