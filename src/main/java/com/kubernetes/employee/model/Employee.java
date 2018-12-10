package com.kubernetes.employee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class Employee implements Serializable{

    private static final long serialVersionUID = -4235680428469660467L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="employee_id")
    private Integer id;

    @Column(name="employee_name",nullable=false)
    private String name;

    @Column(name="employee_department",nullable=false)
    private String department;

    @Column(name="email")
    private String email;

}