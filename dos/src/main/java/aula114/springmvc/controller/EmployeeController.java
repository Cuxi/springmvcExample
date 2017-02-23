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

  @RequestMapping(value="/show", method = RequestMethod.POST)
  public String show(Model model, @RequestParam("clave") String clave){
	Contact contact=new Contact();
	contact=employeeService.show(clave);
	model.addAttribute("contact", contact);
	System.out.println("--------------------------");
	return "consulta";
  }
   
  @RequestMapping(value="/employee", method = RequestMethod.GET)
  public String consulta(Model model) {
    	model.addAttribute("contact", employeeService.listIdEmployee());
        System.out.println("++++++++++++++++++++");
    	return "list";
  }

  @RequestMapping("/eliminar")
  public String cargaEliminar (Model model){
	return "delete";
  }

  @RequestMapping(value="/delete", method = RequestMethod.POST)
  public String delete (Model model, @RequestParam(value = "id", required = false) String id){
	if(id!=null){
		int c=employeeService.delete(id);
		model.addAttribute("filas",c);
		return "deleteOK";
	}else{
		return "delete";	
	}
  }

  @RequestMapping("/add")
  public String cargaInsertar (Model model){
	return "add";
  }

  @RequestMapping(value="/insert", method = RequestMethod.POST)
  public String insertar(Model model,@ModelAttribute Contact contact){
	if(contact!=null){
		int c = employeeService.insert(contact);
		model.addAttribute("resultado", c);

		return "updateOK";
	}else{
		return "add";
	}
	
  }

  @RequestMapping("/edit")
  public String cargaEditar (Model model){
	return "edit";
  }


  @RequestMapping(value="/editar", method = RequestMethod.POST)
  public String editar (Model model,
		@RequestParam(value="id") String id,
		@RequestParam(value="name", required=false) String name,
		@RequestParam(value="address", required=false) String address,
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="telephone", required=false) String telephone){
	if(id==null){
		Contact contact=new Contact();
		if(name!=null){contact.setName(name);}
		if(address!=null){contact.setAddress(address);}
		if(email!=null){contact.setEmail(email);}
		if(telephone!=null){contact.setTelephone(telephone);}

		int c = employeeService.insert(contact);
		model.addAttribute("resultado", c);

		return "updateOK";	
	}else{
		return "edit";
	}

  }

}
