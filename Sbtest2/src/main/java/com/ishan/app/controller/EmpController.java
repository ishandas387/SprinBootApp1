package com.ishan.app.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ishan.app.entity.Employee;
import com.ishan.app.service.EmployeeService;

@Controller
public class EmpController {

	@Autowired
	EmployeeService es;
	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public String list(Model model){
		final String uri = "http://localhost:8080/e";

		RestTemplate restTemplate = new RestTemplate();
		Employee[] result = restTemplate.getForObject(uri, Employee[].class);


		model.addAttribute("emplist", result);
		return "home";
	}

	@RequestMapping(value = "/emps", method = RequestMethod.POST)
	public String addEmp(@ModelAttribute Employee e) {

		final String posturi = "http://localhost:8080/e/";

		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject( posturi, e, Employee.class);
		return "redirect:/emps";
	}



	@RequestMapping("/employee/{id}")
	public String showEmp(@PathVariable Long id, Model model){
		final String geturi = "http://localhost:8080/e/{id}";
		System.out.println("in");
		RestTemplate restTemplate = new RestTemplate();

		Employee result = restTemplate.getForObject(geturi, Employee.class,id);

		model.addAttribute("emp", result);
		return "employeedetails";
	}

	@RequestMapping(value = "/emp/del/{id}")
	public String delEmp(@PathVariable Long id){
		System.out.println("in");
		final String deluri = "http://localhost:8080/e/del/{id}";

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.delete(deluri,id);
		return "redirect:/emps";
	}






}
