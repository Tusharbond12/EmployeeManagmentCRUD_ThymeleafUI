package com.tusharcrud.springboottest.controller;


import com.tusharcrud.springboottest.model.Employee;
import com.tusharcrud.springboottest.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Slf4j
@Controller
public class ManageEmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;




    @ModelAttribute("employee")
    public Employee employee() {
        return new Employee();
    }

    @RequestMapping(value={"/manageEmployee"})
    public String manageEmployee()
        {
            return "manageEmployee.html";
        }

     @RequestMapping(value="/updateElement",method= RequestMethod.POST)
     public String updateElement(@Valid @ModelAttribute Employee employee, Errors errors)
     {

         if(errors.hasErrors()){
             log.error("Contact form validation failed due to : " + errors.toString());
             return "manageEmployee.html";
         }
         if(!(employee.name.equals("") || employee.role.equals("")) )
         employeeRepository.save(employee);
         return "redirect:/manageEmployee";

     }

     @Transactional
     @RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
     public String deleteEmployee(@RequestParam  String name)
     {
         employeeRepository.deleteByname(name);
         return "redirect:/manageEmployee";

     }

     @RequestMapping(value="/updateRole",method=RequestMethod.POST)
    public String updateRole(@RequestParam String name,@RequestParam String role)
     {

         Employee employee2 = employeeRepository.findByname(name);
         employee2.setRole(role);
         employeeRepository.save(employee2);
         return "redirect:/manageEmployee";
     }







}
