package com.practice.validateEmployee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(value= ActivityId.class)
public class Activity {
    @Id
    private int idUser;
    @Id
    private int idProyect;

    private int numHours;
}
