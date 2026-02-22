package com.practice.validateEmployee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartment {
    @EmbeddedId
    private EmployeeDepartmentId id;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    private Employee employee;

    @ManyToOne
    @MapsId("idDepartment")
    @JoinColumn(name = "id_department",referencedColumnName = "id")
    private Department department;

    private boolean fullTime;
}
