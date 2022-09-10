package com.tusharcrud.springboottest.repository;

import com.tusharcrud.springboottest.model.Employee;
import com.tusharcrud.springboottest.service.EmployeeService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    int deleteByname(String name);

    Employee findByname(String name);


//    @Modifying
//    @Query("update employeeinfo c set c.role= :role where c.name= :name")
//    int updatePostByName(String name ,String role);

}
