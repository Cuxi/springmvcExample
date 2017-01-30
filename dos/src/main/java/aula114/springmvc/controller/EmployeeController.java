package aula114.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;

import aula114.springmvc.service.*;
import aula114.springmvc.domain.Contact;

import java.util.List;
import java.util.ArrayList;

@Controller
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService=new EmployeeServiceImpl();
  private Contact contact;
/*
  @RequestMapping("/show/{clave}")
  public ... {
    //  
  }
  */
  @RequestMapping("/show")
  public void employeeList(Model model) {
    List<Contact> employeeList=employeeService.listIdEmployee();
    model.addAttribute("employeeList", employeeList);
  }
  
  @RequestMapping("/employee")
  public String employeeShowList (@ModelAttribute("contact") @Valid Contact contact, BindingResult result) {
    if(result.hasErrors()) {
      // show the form again, with the errors
      return "contact/error";
    }
  
    // validation was successful
   // employeeService.create(contact);
    return "redirect:/contact/list";  
  }
}
