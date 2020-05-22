package com.example.gatos_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data()
@Entity
public class Cat {

    @Id
    public String id;

    @NotNull
    @Size(min = 3, max = 100)
    public String name;

    @Range(min = 0, max = 30)
    public int age;
}
