package com.practice.validateEmployee.entities;


import com.practice.validateEmployee.common.StateEmployee;
import com.practice.validateEmployee.common.TypeEmployee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String username;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private TypeEmployee type;
    @Enumerated(EnumType.ORDINAL)
    private StateEmployee state;
    private float salary;
    private LocalDate hireDate;
}
