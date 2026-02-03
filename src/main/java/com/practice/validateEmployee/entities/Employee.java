package com.practice.validateEmployee.entities;


import com.practice.validateEmployee.common.StateEmployee;
import com.practice.validateEmployee.common.TypeEmployee;

import com.practice.validateEmployee.common.validation.Create;
import com.practice.validateEmployee.common.validation.Modify;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
    @NotBlank(groups = {Create.class, Modify.class})
    private String username;
   @NotBlank(message = "{error.employee.name.notBlank}",groups = {Create.class, Modify.class})
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private TypeEmployee type;
    @Enumerated(EnumType.ORDINAL)
    private StateEmployee state;
    @Min(value = 1000, message = "{error.employee.salary.min1000}",groups = {Modify.class})
    private float salary;
    @PastOrPresent(groups = {Modify.class})
    private LocalDate hireDate;


}
