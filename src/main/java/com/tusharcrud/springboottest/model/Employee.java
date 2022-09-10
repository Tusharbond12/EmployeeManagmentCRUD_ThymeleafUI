package com.tusharcrud.springboottest.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="employeeinfo")
public class Employee {

    @Id
    @Column(name="employee_id")
    public int employeeId;
    public String name;
    public String role;
}
