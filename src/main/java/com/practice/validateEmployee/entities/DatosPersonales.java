package com.practice.validateEmployee.entities;

import com.practice.validateEmployee.common.validation.Create;
import com.practice.validateEmployee.common.validation.Modify;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DatosPersonales {

    @NotBlank(message = "{error.employee.name.notBlank}",groups = {Create.class, Modify.class})
    private String name;
    private String surname;
    @Min(value = 17, message = "{error.employee.age.min18}",groups = {Create.class, Modify.class})
    private int age;
}
