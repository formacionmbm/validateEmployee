package com.practice.validateEmployee.dto;

import com.practice.validateEmployee.common.validation.Create;
import com.practice.validateEmployee.common.validation.Modify;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long idUser;
    private String username;
    private String name;
    private String surname;
}
