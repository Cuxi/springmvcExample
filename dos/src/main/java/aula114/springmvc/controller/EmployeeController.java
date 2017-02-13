package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping("/show/{clave}")
  public String show(Model model, @PathVariable String clave){
	model.addAttribute("aContact", employeeService.show(clave));

	return "list";
  }
   
  @RequestMapping("/employee")
  public String consulta(Model model) {
    	model.addAttribute("contact", employeeService.listIdEmployee());
    
    	return "consulta";
  }

  @RequestMapping("/delete")
  public String delete (Model model, @RequestParam(value = "clave", required = false) String id){

	int c=employeeService.delete(id);
	Contact contact = new Contact();

	model.addAttribute("filas",c);

	return "deleteOK";
  }

  @RequestMapping("/insert")
  public String insertar(Model model,@RequestParam(value="name") String name,@RequestParam(value="address") String address,@RequestParam(value="email") String email,@RequestParam(value="telephone") String telephone){
	Contact contact=new Contact();
	contact.setName(name);
	contact.setAddress(address);
	contact.setEmail(email);
	contact.setTelephone(telephone);

	int c = employeeService.insert(contact);
	model.addAttribute("resultado", c);

	return "insertOK";
	
  }


  @RequestMapping("/editar/")
  public String editar (Model model,@RequestParam(value="id") String id,@RequestParam(value="name", required=false) String name,@RequestParam(value="address", required=false) String address,@RequestParam(value="email", required=false) String email,@RequestParam(value="telephone", required=false) String telephone){

	Contact contact=new Contact();
	if(name!=null){contact.setName(name);}
	if(address!=null){contact.setAddress(address);}
	if(email!=null){contact.setEmail(email);}
	if(telephone!=null){contact.setTelephone(telephone);}

	int c = employeeService.insert(contact);
	model.addAttribute("resultado", c);

	return "updateOK";
  }

}
