package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import aula114.springmvc.service.EmployeeService;
import aula114.springmvc.domain.Contact;

import java.util.List;
import java.util.ArrayList;


@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping(value="/show/{clave}", method = RequestMethod.GET)
  public String show(Model model, @PathVariable String clave){
	model.addAttribute("aContact", employeeService.show(clave));

	return "list";
  }
   
  @RequestMapping(value="/employee", method = RequestMethod.GET)
  public String consulta(Model model) {
    	model.addAttribute("contact", employeeService.listIdEmployee());
        System.out.println("++++++++++++++++++++");
    	return "consulta";
  }

  @RequestMapping(value="/delete", method = RequestMethod.GET)
  public String delete (Model model, @ModelAttribute("contactDelete") String id){

	int c=employeeService.delete(id);

	model.addAttribute("filas",c);

	return "deleteOK";
  }

  @RequestMapping("/add")
  public String cargaInsertar (Model model){
	return "add";
  }

  @RequestMapping(value="/insert", method = RequestMethod.GET)
  public String insertar(Model model,@ModelAttribute("contactInsert") Contact contact){
	Contact contact1=new Contact();
	contact1.setName(contact.getName());
	contact1.setAddress(contact.getAddress());
	contact1.setEmail(contact.getEmail());
	contact1.setTelephone(contact.getTelephone());

	int c = employeeService.insert(contact1);
	model.addAttribute("resultado", c);

	return "updateOK";
	
  }

  @RequestMapping("/edit")
  public String cargaEditar (Model model){
	return "edit";
  }


  @RequestMapping(value="/editar", method = RequestMethod.GET)
  public String editar (Model model,@ModelAttribute("contactEdit") Contact contact){

	Contact contact1=new Contact();
	if(contact.getName()!=null){contact1.setName(contact.getName());}
	if(contact.getAddress()!=null){contact1.setAddress(contact.getAddress());}
	if(contact.getEmail()!=null){contact1.setEmail(contact.getEmail());}
	if(contact.getTelephone()!=null){contact1.setTelephone(contact.getTelephone());}

	int c = employeeService.insert(contact1);
	model.addAttribute("resultado", c);

	return "updateOK";
  }

}
