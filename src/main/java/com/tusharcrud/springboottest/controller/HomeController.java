package com.tusharcrud.springboottest.controller;

import com.tusharcrud.springboottest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class HomeController {


    @Autowired
    private EmployeeRepository rep;

    @RequestMapping(value={"/home"})
    public ModelAndView displayHome()
    {
        ModelAndView mav=new ModelAndView("home");
        mav.addObject("Employes",rep.findAll());
        return mav;
    }


}
